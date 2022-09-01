
/*Phone: id, Прізвище, Ім'я, По батькові, Номер рахунку, Час міських розмов, Час міжміських розмов.
  Скласти масив об'єктів. Вивести:
  a) відомості про абонентів, у яких час міських розмов перевищує заданий;
  b) відомості про абонентів, які користувались міжміським зв'язком;
  c) відомості про абонентів чий номер рахунку знаходиться у вказаному діапазоні.
*/
public class Phone {
    int id;
    String name;
    String middleName;
    int number;
    double inTime;
    double outTime;
    public Phone(int tid, String tname, String tmname, int tnumber, double tin, double tout){
        id = tid;
        name = tname;
        middleName = tmname;
        number = tnumber;
        inTime = tin;
        outTime = tout;
    }

    void SetId(int tid){
        if(tid > 0)
            id = tid;
    }
    public int GetId(){
        return id;
    }
    void SetName(String tname){
        name = tname;
    }
    public String GetName(){
        return name;
    }
    void SetMiddleName(String tname){
        middleName = tname;
    }
    public String GetMiddleName(){
        return middleName;
    }
    void SetNumber(String tnum){
        name = tnum;
    }
    public int GetNumber(){
        return number;
    }
    public double GetOutTime(){
        return outTime;
    }
    public double GetinTime(){
        return inTime;
    }
    void SetInTime(double time){
        if(time >= 0)
            inTime = time;
    }
    void SetOutTime(double time){
        if(time >= 0)
            outTime = time;
    }
}
