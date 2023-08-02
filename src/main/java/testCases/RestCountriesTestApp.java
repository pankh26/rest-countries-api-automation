package testCases;


import java.util.*;

import org.testng.TestNG;

public class RestCountriesTestApp {

    public static Map<String, String> paramMap = new HashMap<>();

        public static void main(String[] args) {

            // Using Scanner for Getting Input from User
            Scanner in = new Scanner(System.in);

            System.out.println("Please enter 'name' for search by name / 'code' for search by code ");

            String s = in.nextLine();

            if (s.equalsIgnoreCase("name")) {
                while (true) {
                    System.out.println("Please enter name: ");
                    String name = in.nextLine();
                    paramMap.put("name",name);
                    testSuiteSelect("testngName");
                    System.out.println("Do you want to continue y/n?");
                    String ans = in.nextLine();
                    if (ans.equalsIgnoreCase("n"))
                        System.exit(0);
                }
            }
            if (s.equalsIgnoreCase("code")) {
                while (true) {
                    System.out.println("Please enter code: ");
                    String code = in.nextLine();
                    paramMap.put("code",code);
                    testSuiteSelect("testngCode");
                    System.out.println("Do you want to continue y/n?");
                    String ans = in.nextLine();
                    if (ans.equalsIgnoreCase("n"))
                        System.exit(0);
                }
            }
        }

        private static void testSuiteSelect( String suiteName){
            // Create object of TestNG Class
            TestNG runner=new TestNG();

            // Create a list of String
            List<String> suitefiles=new ArrayList<String>();

            // Add xml file which you have to execute
            suitefiles.add("C:\\Users\\1991p\\Documents\\Automation Challenge framework\\RestCountries_APIautomation\\" + suiteName + ".xml");

            // now set xml file for execution
            runner.setTestSuites(suitefiles);

            // finally execute the runner using run method
            runner.run();

        }

    }
