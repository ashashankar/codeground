package com.myplayground.playground;

import java.util.HashMap;
import java.util.Map;

public class LookUpEmployee {
    /**
     * Given an organization chart.
     * ORG_CHART = { 'mark':
     *                  { 'jason': None,
     *                  'jenny':
     *                      {
     *                      'tom': None,
     *                      'rachel':
     *                          {
     *                          'peter': None,
     *                          'jeff':
         *                          {
         *                          'annie': None, '
         *                          andy': None,
         *                          }
     *                           }
     *                          }
     *                     },
     *                    'john': None,
     *                }
     *   Write a look up function to return the role, direct reports and total reports under the employee
     *   ex: lookup("rachel") → ("manager", 2, 4) lookup("john") → ("IC", 0, 0)
     *   if the user has no reportees the role is mapped to IC.
     *   direct_reports = number of immediate children.
     *   total_reports = total number of people under them (direct + indirect).
     */
    private static final Map<String, Object> ORG_CHART = new HashMap<>();

    public static void main(String[] args) {
        Map<String, Object> jeffReports = new HashMap<>();
        jeffReports.put("annie", null);
        jeffReports.put("andy", null);

        Map<String, Object> rachelReports = new HashMap<>();
        rachelReports.put("peter", null);
        rachelReports.put("jeff", jeffReports);

        Map<String, Object> jennyReports = new HashMap<>();
        jennyReports.put("tom", null);
        jennyReports.put("rachel", rachelReports);

        Map<String, Object> markReports = new HashMap<>();
        markReports.put("jason", null);
        markReports.put("jenny", jennyReports);

        ORG_CHART.put("mark", markReports);
        ORG_CHART.put("john", null);
        lookUp("rachel");
        lookUp("rachel");
    }

    public static void lookUp(String name) {
        if (name == null || name.length()  == 0) {
            System.out.println("Invalid input");
            return;
        }

        Employee employee = lookUpRecursive(name, ORG_CHART);
        System.out.println(employee.role + " " + employee.directReports + " " + employee.totalReports);
    }

    public static Employee lookUpRecursive(String person, Map<String, Object> orgChart) {
        for (Map.Entry<String, Object> entry : orgChart.entrySet()) {
            String name = entry.getKey();
            Object value = entry.getValue();
            Map<String, Object> reportee = (value instanceof Map)?(Map<String, Object>)value  : null;
            if (name.equals(person)) {
                String role = (reportee == null)? "IC" : "Manager";
                int direct_reports = (reportee == null)?0: reportee.size();
                int total_reports = (direct_reports == 0)? 0 : getSubReporteesCount(reportee);
                return new Employee(role, direct_reports, total_reports);
            }

            if (reportee != null) {
                Employee emp = lookUpRecursive(person, reportee);
                if (emp != null) return emp;
            }
        }
        return null;
    }

    public static int getSubReporteesCount(Map<String, Object> reportees) {
        int total = 0;
        for (Map.Entry<String, Object> entry : reportees.entrySet()) {
            total += 1;
            Map<String, Object> sub_reporte = (value instanceof Map) ? (Map<String, Object>)entry.getValue() :null;
            if (sub_reporte != null) {
                total += getSubReporteesCount(sub_reporte);
            }
        }

        return total;
    }


}

class  Employee {
    String role;
    int directReports;
    int totalReports;
    Employee(String role, int d_r, int t_r) {
        this.role = role;
        this.directReports = d_r;
        this.totalReports = t_r;
    }
}
