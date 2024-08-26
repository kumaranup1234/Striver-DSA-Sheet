package Strings;

import java.util.Arrays;

public class getMeThatQueryParam {
    public static String[] getParam(String url, int n, String[] name){
        String[] res = new String[n];
        boolean queryStart = false;
        StringBuilder query = new StringBuilder();


        // extracting the imp part
        for(int i=0; i<url.length(); i++){
            if (url.charAt(i) == '?'){
                queryStart = true;
                continue;
            }
            // else build the string
            if (queryStart){
                query.append(url.charAt(i));
            }
        }


        for (int i = 0; i < n; i++) {
            // if not found
            res[i] = "-1";


            String paramName = name[i] + "=";
            // starting index of the parameter
            int index = query.indexOf(paramName);


            if (index != -1){
                // if param is present
                // starting will be starting index + the length of the param string
                int start = index + paramName.length();
                // end will be the pos where & is found
                int end = query.indexOf("&", start);
                // if end not -1 means there are more param present
                if (end != -1){
                    res[i] = query.substring(start, end);
                    // if -1 means that no param is present it,s the end of param as no more & is present
                } else {
                    res[i] = query.substring(start);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String url1 = "https://www.deltax.com/career?test_param=google&param_1=india";
        String url2 = "https://www.deltax.com/career?test_param=google&param_1=";  // Edge case: empty value
        String url3 = "https://www.deltax.com/career?test_param=google";  // Edge case: only one parameter
        String url4 = "https://www.deltax.com/career";  // Edge case: no query parameters
        String url5 = "https://www.deltax.com/career?test_param=google&param_15=test&param_1=india";  // Extra parameter present

        int n = 2;
        String[] name = {"test_param", "param_15"};

        System.out.println(Arrays.toString(getParam(url1, n, name))); // Expected: ["google", "-1"]
        System.out.println(Arrays.toString(getParam(url2, n, name))); // Expected: ["google", "-1"]
        System.out.println(Arrays.toString(getParam(url3, n, name))); // Expected: ["google", "-1"]
        System.out.println(Arrays.toString(getParam(url4, n, name))); // Expected: ["-1", "-1"]
        System.out.println(Arrays.toString(getParam(url5, n, name))); // Expected: ["google", "test"]
    }
}
