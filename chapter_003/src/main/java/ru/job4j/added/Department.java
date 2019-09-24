package ru.job4j.added;

import java.util.*;

/**
 * @author Vasily Tungusov
 * @version 1.0
 */

public class Department {
    /**
     * Sort array by ascending
     *
     * @param dep initial array
     * @return sorted array
     */
    public static String[] sortAsc(String[] dep) {
        String[] recoverDep = addMissing(dep);
        List<String> raw = Arrays.asList(recoverDep);
        raw.sort((o1, o2) -> o1.compareTo(o2));
        return raw.toArray(new String[0]);
    }

    /**
     * Sort array by descending
     *
     * @param dep initial array
     * @return sorted array
     */

    public static String[] sortDesc(String[] dep) {
        String[] recoverDep = addMissing(dep);
        List<String> raw = Arrays.asList(recoverDep);
        raw.sort((o1, o2) -> {
                    int minLength = Math.min(o1.length(), o2.length());
                    int result = o1.length() - o2.length();
                    for (int i = 0; i < minLength; i++) {
                        char left = o1.charAt(i);
                        char right = o2.charAt(i);
                        if (right - left != 0) {
                            result = right - left;
                            break;
                        }
                    }
                    return result;
                }
        );
        return raw.toArray(new String[0]);
    }

    /**
     * Added missing department to department hierarсhy
     *
     * @param departments initial department arrays
     * @return department arrays with recovery hierarсhy
     */
    private static String[] addMissing(String[] departments) {
        Set<String> departmentsSet = new HashSet<>(Arrays.asList(departments));
        StringTokenizer tokenizer;
        for (String part : departments) {
            StringJoiner joiner = new StringJoiner("\\");
            tokenizer = new StringTokenizer(part, "\\");
            while (tokenizer.hasMoreTokens()) {
                String token = tokenizer.nextToken();
                joiner.add(token);
                departmentsSet.add(joiner.toString());
            }
        }
        return departmentsSet.toArray(new String[0]);
    }

}
