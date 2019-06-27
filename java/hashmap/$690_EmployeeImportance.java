package array;

public class $690_EmployeeImportance {
    public int getImportance(List<Employee> employees, int id) {
        if(employees.size() == 0) return 0;
        for(Employee e : employees){
            //获取id指定的Empolyee
            if(e.id == id){
                int sum = e.importance;
                //dfs
                if(e.subordinates.size() > 0){
                    for(int subId : e.subordinates){
                        sum += getImportance(employees,subId);
                    }
                }
                return sum;
            }
        }
        return 0;
    }
}
