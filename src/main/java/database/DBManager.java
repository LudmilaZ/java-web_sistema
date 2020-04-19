package database;

import entity.*;

import java.sql.*;
import java.util.*;

public class DBManager {
    private static Connection con;
    private static PreparedStatement changeDisciplines;
    private static PreparedStatement getAllActiveStudentes;
    private static PreparedStatement insertStudents;
    private static PreparedStatement changeStudents;
    private static PreparedStatement getAccauntByLoginPasswordRole;
    private static PreparedStatement getDisciplinesByTerm;
    private static PreparedStatement getAllActiveTerm;
    private static PreparedStatement getProgress;
    private static PreparedStatement getUltomoTerm;
    private static PreparedStatement serUltomoTerm;
    private static PreparedStatement setTermDisciplina;
    private static PreparedStatement updateTermByID;
    private static PreparedStatement updateTermDisciplina;
    private static PreparedStatement deleteTermDisciplineByTerm;
    private static PreparedStatement deleteTerm;
    private static PreparedStatement language;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/student_crm?useUnicode=true&serverTimezone=UTC", "root", "489178qq");


            changeDisciplines = con.prepareStatement("UPDATE `student_crm`.`disciplina` SET `disciplina` = ? WHERE (`id` = ?);");
            getAllActiveStudentes = con.prepareStatement("SELECT * FROM student_crm.student where status=1;");
            insertStudents = con.prepareStatement("INSERT INTO `student_crm`.`student` (`surname`, `name`, `nomber_grup`, `date_aprobarse`, `status`) VALUES (?, ?, ?, ?, '1');");
            changeStudents = con.prepareStatement("UPDATE `student_crm`.`student` SET `surname` = ?, `name` = ?, `nomber_grup` = ?, `date_aprobarse` = ? WHERE (`id` = ?);");
            getAccauntByLoginPasswordRole = con.prepareStatement("SELECT * FROM user_role left join user on user_role.id_user = user.id where user.login = ? and user.password = ? and user_role.id_role =?;");
            language = con.prepareStatement("SELECT * FROM student_crm.language;");
            getAllActiveTerm = con.prepareStatement("SELECT \n" +
                    "    terms.id,\n" +
                    "    CASE\n" +
                    "        WHEN disciplina.status IS NULL THEN 0\n" +
                    "        ELSE 1\n" +
                    "    END AS status,\n" +
                    "    terms_discipline.id_terms,\n" +
                    "    terms_discipline.id_discipline,\n" +
                    "    terms.name_term,\n" +
                    "    terms.tiempo_term,\n" +
                    "    disciplina.status AS status1,\n" +
                    "    disciplina.disciplina\n" +
                    "FROM\n" +
                    "    terms\n" +
                    "        LEFT OUTER JOIN\n" +
                    "    terms_discipline ON terms_discipline.id_terms = terms.id\n" +
                    "        LEFT OUTER JOIN\n" +
                    "    disciplina ON terms_discipline.id_discipline = disciplina.id\n" +
                    "WHERE\n" +
                    "    terms.status = '1'\n" +
                    "        AND CASE\n" +
                    "        WHEN NOT disciplina.status IS NULL THEN disciplina.status = 1\n" +
                    "        ELSE terms.status = '1'\n" +
                    "    END\n" +
                    "ORDER BY id");

            getDisciplinesByTerm = con.prepareStatement("select d.disciplina, d.id, d.status, t.TID, t.name_term, t.tiempo_term\n" +
                    " from disciplina as d \n" +
                    "left outer join (SELECT \n" +
                    "    terms.id ,\n" +
                    "    terms.status,\n" +
                    "    terms_discipline.id_terms as TID,\n" +
                    "    terms_discipline.id_discipline,\n" +
                    "    terms.name_term as name_term,\n" +
                    "    terms.tiempo_term as tiempo_term,\n" +
                    "    disciplina.disciplina \n" +
                    "FROM\n" +
                    "    terms\n" +
                    "        LEFT OUTER JOIN\n" +
                    "    terms_discipline ON terms_discipline.id_terms = terms.id\n" +
                    "        LEFT OUTER JOIN\n" +
                    "    disciplina ON terms_discipline.id_discipline = disciplina.id\n" +
                    "WHERE\n" +
                    "    terms.id = ?)as t  on d.id=t.id_discipline\n" +
                    "    where d.status= 1\n" +
                    "    order by  t.name_term desc; ");
            getProgress = con.prepareStatement("SELECT \n" +
                    "    student.id AS idStud,\n" +
                    "    student.surname,\n" +
                    "    student.name,\n" +
                    "    student.nomber_grup,\n" +
                    "    student.date_aprobarse,\n" +
                    "    progress.evaluacion,\n" +
                    "    progress.id_term_disciplina,\n" +
                    "    terms_discipline.id_terms AS id,\n" +
                    "    terms_discipline.id_discipline,\n" +
                    "    terms.name_term,\n" +
                    "    terms.id AS term_id,\n" +
                    "    disciplina.disciplina\n" +
                    "FROM\n" +
                    "    student_crm.student\n" +
                    "        LEFT JOIN\n" +
                    "    progresos AS progress ON progress.id_student = student.id\n" +
                    "        LEFT JOIN\n" +
                    "    terms_discipline ON progress.id_term_disciplina = terms_discipline.id\n" +
                    "        LEFT JOIN\n" +
                    "    terms ON terms_discipline.id_terms = terms.id\n" +
                    "        LEFT JOIN\n" +
                    "    disciplina ON terms_discipline.id_discipline = disciplina.id\n" +
                    "WHERE\n" +
                    "    student.id = ?\n" +
                    "ORDER BY term_id");

            getUltomoTerm = con.prepareStatement("SELECT \n" +
                    "id,\n" +
                    "number_terml\n" +
                    " FROM student_crm.terms  \n" +
                    " order by number_terml DESC\n" +
                    " limit 1");
            setTermDisciplina = con.prepareStatement("INSERT INTO `student_crm`.`terms_discipline` (`id_terms`, `id_discipline`) VALUES (?, ?);");

            serUltomoTerm = con.prepareStatement("INSERT INTO `student_crm`.`terms` (`tiempo_term`, `name_term`, `number_terml`) VALUES (?, ?, ?);");

            updateTermByID = con.prepareStatement("UPDATE `student_crm`.`terms` SET `tiempo_term` = ? WHERE (`id` = ?);");
            updateTermDisciplina = con.prepareStatement("UPDATE `student_crm`.`terms_discipline` SET `id_discipline` = ? WHERE (`id` = ?');");
deleteTermDisciplineByTerm = con.prepareStatement("DElete  FROM student_crm.terms_discipline where terms_discipline.id_terms= ?;");
            deleteTerm = con.prepareStatement("UPDATE `student_crm`.`terms` SET `status` = '0' WHERE (`id` = ?);");
        } catch (Exception e) {
        }
    }

    public static List<Discipline> getAllActiveDisciplines() {
        ArrayList<Discipline> disciplines = new ArrayList<Discipline>();
        try {

            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("select * from disciplina WHERE status=1");
            while (rs.next()) {
                Discipline discipline = new Discipline();
                discipline.setId(rs.getInt("id"));
                discipline.setDiscipline(rs.getString("disciplina"));
                disciplines.add(discipline);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return disciplines;
    }

    public static List<Studentes> getAllActiveStudentes() {
        ArrayList<Studentes> studentes = new ArrayList<Studentes>();
        try {


            ResultSet rs = getAllActiveStudentes.executeQuery();
            while (rs.next()) {
                Studentes studente = new Studentes();
                studente.setId(rs.getInt("id"));
                studente.setName(rs.getString("name"));
                studente.setSurname(rs.getString("surname"));
                studente.setDate_aprobarse(rs.getDate("date_aprobarse"));
                studente.setNomber_grup(rs.getString("nomber_grup"));
                studentes.add(studente);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentes;
    }

    public static Discipline getDisciplinesByID(String id) {
        Discipline disciplina = new Discipline();
        try {

            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("select * from disciplina WHERE (`id` = '" + id + "');");
            while (rs.next()) {

                disciplina.setId(rs.getInt("id"));
                disciplina.setDiscipline(rs.getString("disciplina"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return disciplina;
    }

    public static Studentes getStudentByID(String id) {
        Studentes studente = new Studentes();
        try {

            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("select * from student WHERE (`id` = '" + id + "');");
            while (rs.next()) {

                studente.setId(rs.getInt("id"));
                studente.setName(rs.getString("name"));
                studente.setSurname(rs.getString("surname"));
                studente.setDate_aprobarse(rs.getDate("date_aprobarse"));
                studente.setNomber_grup(rs.getString("nomber_grup"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studente;
    }

    public static void insertDisciplines(String newDiscipline) {

        try {
            Statement stm = con.createStatement();
            stm.execute("INSERT INTO `student_crm`.`disciplina` (`disciplina`) VALUES ('" + newDiscipline + "');");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void insertStudents(String name, String surname, String nomber_grup, String date_aprobarse) {

        try {


            insertStudents.setString(1, surname);
            insertStudents.setString(2, name);
            insertStudents.setString(3, nomber_grup);
            insertStudents.setString(4, date_aprobarse);


            insertStudents.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void changeDisciplines(String numberOFDisciplina, String newName) {

        try {
//            PreparedStatement stm = con.prepareStatement("UPDATE `student_crm`.`disciplina` SET `disciplina` = ? WHERE (`id` = ?);");
            changeDisciplines.setString(1, newName);
            changeDisciplines.setString(2, numberOFDisciplina);
            changeDisciplines.execute();
            //   stm.execute("UPDATE `student_crm`.`disciplina` SET `disciplina` = '"+newName+"' WHERE (`id` = '"+numberOFDisciplina+"');");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteDisciplines(String ids) {

        try {
            Statement stm = con.createStatement();
            stm.execute("UPDATE `disciplina` SET `status` = '0' WHERE (`id` in (" + ids + "));");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteStudentes(String ids) {

        try {
            Statement stm = con.createStatement();
            stm.execute("UPDATE `student_crm`.`student` SET `status` = '0' WHERE (`id` in (" + ids + "));");
//            stm.execute("UPDATE `disciplina` SET `status` = '0' WHERE (`id` in ("+ids+"));");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void changeStudents(String name, String surname, String nomber_grup, String date_aprobarse, String idStudent) {

        try {


            changeStudents.setString(1, surname);
            changeStudents.setString(2, name);
            changeStudents.setString(3, nomber_grup);
            changeStudents.setString(4, date_aprobarse);
            changeStudents.setString(5, idStudent);

            changeStudents.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Users> getAllUsers() {
        ArrayList<Users> users = new ArrayList<Users>();
        try {

            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT \n" +
                    "    user.id,\n" +
                    "   user.login,\n" +
                    "   user.password,\n" +
                    "   user_role.id_user,\n" +
                    "   user_role.id_role,\n" +
                    "   role.role\n" +
                    "  \n" +
                    "FROM\n" +
                    "    user LEFT OUTER JOIN user_role \n" +
                    "\t     ON user.id = user_role.id_user LEFT OUTER JOIN role\n" +
                    "\t     ON user_role.id_role = role.id");
            while (rs.next()) {
                Users user = new Users();
                user.setId(rs.getInt("id"));
                user.setLogin(rs.getString("login"));
                user.setPasword(rs.getString("password"));
                user.setRole(rs.getString("role"));
                users.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    public static boolean getAccauntByLoginPasswordRole(String login, String password, String role) {
        Account account = new Account();
        try {

            getAccauntByLoginPasswordRole.setString(1, login);
            getAccauntByLoginPasswordRole.setString(2, password);
            getAccauntByLoginPasswordRole.setString(3, role);
            ResultSet rs = getAccauntByLoginPasswordRole.executeQuery();
            while (rs.next()) {

                return true;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    public static LinkedList<Term> getDisciplinesByTerm(String id) {

        LinkedList<Term> terms = new LinkedList<Term>();
        try {
            getDisciplinesByTerm.setString(1, id);
            ResultSet rs = getDisciplinesByTerm.executeQuery();
            int firstFila = -1;
            while (rs.next()) {
                if (firstFila == -1) {
                    Term term = new Term();

                    term.setId(rs.getInt("TID"));

                    term.setId_discipline(rs.getInt("id"));
                    term.setName_term(rs.getString("name_term"));
                    term.setTiempo_term(rs.getDouble("tiempo_term"));
                    Discipline discipline = new Discipline();
                    discipline.setId(rs.getInt("id"));
                    discipline.setDiscipline(rs.getString("disciplina"));
                    if (rs.getInt("TID") > 0) {
                        discipline.setIsUseInTerm(1);
                    }
                    term.addDiscipline(discipline);
                    terms.add(term);
                    firstFila = 1;
                } else {
                    Discipline discipline = new Discipline();
                    discipline.setId(rs.getInt("id"));
                    discipline.setDiscipline(rs.getString("disciplina"));
                    if (rs.getInt("TID") > 0) {
                        discipline.setIsUseInTerm(1);
                    }
                    Term _lastTerm = terms.removeLast();
                    _lastTerm.addDiscipline(discipline);
                    terms.add(_lastTerm);

                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return terms;
    }


    public static TreeMap<Integer,Term> getAllActiveTerm() {
   // public static List<Term> getAllActiveTerm() {
  //    LinkedList<Term> terms = new LinkedList<Term>();
       TreeMap<Integer,Term> terms = new TreeMap<Integer, Term>();
        try {
            ResultSet rs = getAllActiveTerm.executeQuery();
            int lastTerm = -1;

            while (rs.next()) {
                if (lastTerm == -1) {


                    Term term = new Term();
                    term.setId(rs.getInt("id"));

                    term.setId_discipline(rs.getInt("id_discipline"));
                    term.setName_term(rs.getString("name_term"));
                    term.setTiempo_term(rs.getDouble("tiempo_term"));


                    Discipline discipline = new Discipline();
                    discipline.setId(rs.getInt("id_discipline"));
                    discipline.setDiscipline(rs.getString("disciplina"));

                    term.addDiscipline(discipline);

//                   terms.add(term);
                   terms.put(rs.getInt("id"),term);
                    lastTerm = rs.getInt("id");
                } else {
                    int currentTermId = rs.getInt("id");
                    if (currentTermId == lastTerm) {
                        Discipline discipline = new Discipline();
                        discipline.setId(rs.getInt("id_discipline"));
                        discipline.setDiscipline(rs.getString("disciplina"));
Map.Entry<Integer,Term> _lastTermEntry = terms.lastEntry();
                      Term _lastTerm=  _lastTermEntry.getValue();
//                      Term _lastTerm = terms.removeLast();

                        _lastTerm.addDiscipline(discipline);
                        terms.put(rs.getInt("id"),_lastTerm);
//                        terms.add(_lastTerm);
                        lastTerm = rs.getInt("id");
                    } else {
                        Term term = new Term();
                        term.setId(rs.getInt("id"));

                        term.setId_discipline(rs.getInt("id_discipline"));
                        term.setName_term(rs.getString("name_term"));
                        term.setTiempo_term(rs.getDouble("tiempo_term"));


                        Discipline discipline = new Discipline();
                        discipline.setId(rs.getInt("id_discipline"));
                        discipline.setDiscipline(rs.getString("disciplina"));

                        term.addDiscipline(discipline);

//                        terms.add(term);
                        terms.put(rs.getInt("id"),term);
                        lastTerm = rs.getInt("id");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return terms;

    }

    public static List<ProgresosDeStudentes> getProgress(String id) {
        LinkedList<ProgresosDeStudentes> progresosDeStudentes = new LinkedList<ProgresosDeStudentes>();
        try {
            getProgress.setString(1, id);
            ResultSet rs = getProgress.executeQuery();
            int lastTerm = -1;

            while (rs.next()) {
                if (lastTerm == -1) {
                    ProgresosDeStudentes progresosDeStudent = new ProgresosDeStudentes();
                    progresosDeStudent.setId(rs.getInt("id"));
                    progresosDeStudent.setIdStud(rs.getInt("idStud"));

                    progresosDeStudent.setSurname(rs.getString("surname"));
                    progresosDeStudent.setName(rs.getString("name"));
                    progresosDeStudent.setNomber_grup(rs.getString("nomber_grup"));
                    progresosDeStudent.setDate_aprobarse(rs.getDate("date_aprobarse"));
                    progresosDeStudent.setName_term(rs.getString("name_term"));

                    DisciplinaEvalucion disciplinaEvalucion = new DisciplinaEvalucion();
                    Discipline discipline = new Discipline(rs.getString("disciplina"), rs.getInt("id_discipline"));
                    disciplinaEvalucion.setDiscipline(discipline);
                    disciplinaEvalucion.setEvalucion(rs.getInt("evaluacion"));
                    progresosDeStudent.addDiscipline(disciplinaEvalucion);
                    progresosDeStudentes.add(progresosDeStudent);
                    progresosDeStudent.sumValoracionMedia(rs.getInt("evaluacion"));
//                    valoracionMedia = valoracionMedia + rs.getInt("evaluacion");
                    lastTerm = rs.getInt("id");
                } else {
                    int currentTermId = rs.getInt("id");
                    if (currentTermId == lastTerm) {

                        DisciplinaEvalucion disciplinaEvalucion = new DisciplinaEvalucion();
                        Discipline discipline = new Discipline(rs.getString("disciplina"), rs.getInt("id_discipline"));
                        disciplinaEvalucion.setDiscipline(discipline);
                        disciplinaEvalucion.setEvalucion(rs.getInt("evaluacion"));

                        ProgresosDeStudentes _lastProgresosDeStudentos = progresosDeStudentes.removeLast();

                        _lastProgresosDeStudentos.addDiscipline(disciplinaEvalucion);
                        progresosDeStudentes.add(_lastProgresosDeStudentos);

                        progresosDeStudentes.getLast().sumValoracionMedia(rs.getInt("evaluacion"));


                        lastTerm = rs.getInt("id");

                    } else {


                        ProgresosDeStudentes progresosDeStudent = new ProgresosDeStudentes();
                        progresosDeStudent.setId(rs.getInt("id"));
                        progresosDeStudent.setIdStud(rs.getInt("idStud"));
                        progresosDeStudent.setSurname(rs.getString("surname"));
                        progresosDeStudent.setName(rs.getString("name"));
                        progresosDeStudent.setNomber_grup(rs.getString("nomber_grup"));
                        progresosDeStudent.setDate_aprobarse(rs.getDate("date_aprobarse"));
                        progresosDeStudent.setName_term(rs.getString("name_term"));

                        DisciplinaEvalucion disciplinaEvalucion = new DisciplinaEvalucion();
                        Discipline discipline = new Discipline(rs.getString("disciplina"), rs.getInt("id_discipline"));
                        disciplinaEvalucion.setDiscipline(discipline);
                        disciplinaEvalucion.setEvalucion(rs.getInt("evaluacion"));
                        progresosDeStudent.addDiscipline(disciplinaEvalucion);
                        progresosDeStudentes.add(progresosDeStudent);

                        progresosDeStudent.sumValoracionMedia(rs.getInt("evaluacion"));
                        lastTerm = rs.getInt("id");
                    }
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return progresosDeStudentes;
    }

    public static void createTerms(String[] disciplinesEligido, String tiempo_term) {
        int ultimoTerm = 0;
        try {
            ResultSet rs = getUltomoTerm.executeQuery();
            if (rs.next()) {
                ultimoTerm = rs.getInt("number_terml");
            }

            serUltomoTerm.setString(1, tiempo_term);
            serUltomoTerm.setString(2, "Семестр " + (ultimoTerm + 1));
            serUltomoTerm.setInt(3, ultimoTerm + 1);
            serUltomoTerm.execute();
            rs = getUltomoTerm.executeQuery();
            rs.next();
            ultimoTerm = rs.getInt("id");
            for (String disciplina : disciplinesEligido
            ) {
                setTermDisciplina.setInt(1, ultimoTerm);
                setTermDisciplina.setInt(2, Integer.valueOf(disciplina));
                setTermDisciplina.execute();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void updateTermByID(String[] disciplinesEligido, String tiempo_ter, int idTerm) {
        try {
            deleteTermDisciplineByTerm.setInt(1,idTerm);
           updateTermByID.setString(1, tiempo_ter);
           updateTermByID.setInt(2, idTerm);
            updateTermByID.execute();

            for (String disciplina : disciplinesEligido
            ) {
                setTermDisciplina.setInt(1, idTerm);
                setTermDisciplina.setInt(2, Integer.valueOf(disciplina));
//                updateTermDisciplina.setInt(1, Integer.valueOf(disciplina));
//                updateTermDisciplina.setInt(2, idTerm);
                setTermDisciplina.execute();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static void deleteTerm (int idTerm){
        try {
            deleteTerm.setInt(1,idTerm);
            deleteTerm.execute();
        }catch (Exception e){e.printStackTrace();}
    }

    public static List<Language> language (){
        List<Language>languages = new ArrayList<Language>();
        try {
            ResultSet rs = language.executeQuery();
            while (rs.next()) {
                Language language = new Language();
                language.setId(rs.getInt("id"));
                language.setLanguage(rs.getString("language"));
                language.setShot_name(rs.getString("shot_name"));
                languages.add(language);
            }
        }catch (Exception e){e.printStackTrace();}
        return languages;
    }


}
