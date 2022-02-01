package ee.taltech.iti0202.idcode;

public class IdCode {

    public static final int INT = 11;
    public static final int INT1 = 20;
    public static final int INT2 = 271;
    public static final int INT3 = 370;
    public static final int INT4 = 220;
    public static final int INT5 = 21;
    public static final int INT6 = 471;
    public static final int INT7 = 490;
    public static final int INT8 = 221;
    public static final int INT9 = 270;
    public static final int INT10 = 371;
    public static final int INT11 = 420;
    public static final int INT12 = 421;
    public static final int INT13 = 470;
    public static final int INT14 = 491;
    public static final int INT15 = 520;
    public static final int INT16 = 521;
    public static final int INT17 = 570;
    public static final int INT18 = 571;
    public static final int INT19 = 600;
    public static final int INT20 = 601;
    public static final int INT21 = 650;
    public static final int INT22 = 651;
    public static final int INT23 = 710;
    public static final int INT24 = 0;
    public static final int INT25 = 1;
    public static final int INDEX = 2;
    public static final int INT26 = 99;
    public static final int INT27 = 12;
    public static final int INT28 = 2099;
    public static final int INT29 = 1800;
    public static final int INT30 = 30;
    public static final int INT31 = 31;
    public static final int INT32 = 29;
    public static final int INT33 = 28;
    public static final int INT34 = 10;
    public static final int INT35 = 4;
    public static final int INT36 = 100;
    public static final int INT37 = 400;
    private final String idCodeValue;
    enum Gender {
        MALE, FEMALE
    }

    /**
     * Method returns the id code.
     *
     * @return id code.
     */
    public String getIdCodeValue() {
        return idCodeValue;
    }

    public IdCode(String idCodeValue) {
        this.idCodeValue = isCorrectOrNo(idCodeValue) ? idCodeValue : null;
        if (this.idCodeValue == null) {
            throw new IllegalArgumentException();
        }
    }


    /**
     * Get the year that the person was born in.
     *
     * @return int with person's birth year.
     */
    public static boolean isCorrectOrNo(String idCodeValue) {
        boolean test = idCodeValue.length() == INT;
        boolean test2 = idCodeValue.matches("^[0-9]*$");
        return test && test2;
    }

    /**
     * Check if the id code is valid or not.
     *
     * @return boolean describing whether or not the id code was correct.
     */
    public boolean isCorrect() {
        boolean test = idCodeValue.length() == INT;
        boolean test2 = idCodeValue.matches("^[0-9]*$");
        boolean first = isControlNumberCorrect();
        boolean second = isGenderNumberCorrect();
        boolean third = isDayNumberCorrect();
        boolean forth = isMonthNumberCorrect();
        boolean five = isYearNumberCorrect();
        return first && second && third && forth && five && test && test2;
    }

    /**
     * Get all information about id code.
     *
     * @return String containing information.
     */
    public String getInformation() {
        return "This is a " + getGender() + " " + "born on" + " " + getDay() + "." + getMonth() + "." + getFullYear()
                + " " + "in" + " " + getBirthPlace();
    }

    /**
     * Get gender enum.
     *
     * @return enum describing person's gender
     */
    public Gender getGender() {
        if (idCodeValue.charAt(INT24) % INDEX == INT24) {
            return Gender.FEMALE;
        } else {
            return Gender.MALE;
        }
    }

    /**
     * Get person's birth location.
     *
     * @return String with the person's birth place.
     */
    public String getBirthPlace() {
        int number = getNumber();
        if (INT25 <= number && number <= INT34) {
            return "Kuressaare";
        } else if (INT <= number && number <= INT1 || INT2 <= number && number <= INT3) {
            return "Tartu";
        } else if (INT5 <= number && number <= INT4 || INT6 <= number && number <= INT7) {
            return "Tallinn";
        } else if (INT8 <= number && number <= INT9) {
            return "Kohtla-Järve";
        } else if (INT10 <= number && number <= INT11) {
            return "Narva";
        } else if (INT12 <= number && number <= INT13) {
            return "Pärnu";
        } else if (INT14 <= number && number <= INT15) {
            return "Paide";
        } else if (INT16 <= number && number <= INT17) {
            return "Rakvere";
        } else if (INT18 <= number && number <= INT19) {
            return "Valga";
        } else if (INT20 <= number && number <= INT21) {
            return "Viljandi";
        } else if (INT22 <= number && number <= INT23) {
            return "Võru";
        }
        return "unknown";
    }

    /**
     * Get the year that the person was born in.
     *
     * @return int with person's birth year.
     */
    public String removeLastChar(String s) {
        return (s == null || s.length() == INT24)
                ? null
                : (s.substring(INT24, s.length() - INT25));
    }


    public int getFullYear() {
        char yearnum1 = idCodeValue.charAt(INT25);
        String str1 = Character.toString(yearnum1);
        char yearnum2 = idCodeValue.charAt(INDEX);
        String str2 = Character.toString(yearnum2);
        String fullyear = str1 + str2;
        int number = INT24;
        if (idCodeValue.charAt(INT24) == '1' || idCodeValue.charAt(INT24) == '2') {
            String str = "18" + fullyear;
            number = Integer.parseInt(str);
        } else if (idCodeValue.charAt(INT24) == '3' || idCodeValue.charAt(INT24) == '4') {
            String str = "19" + fullyear;
            number = Integer.parseInt(str);
        } else if (idCodeValue.charAt(INT24) == '5' || idCodeValue.charAt(INT24) == '6') {
            String str = "20" + fullyear;
            number = Integer.parseInt(str);
        }
        return number;
    }

    /**
     * Check if gender number is correct.
     *
     * @return boolean describing whether the gender number is correct.
     */
    private boolean isGenderNumberCorrect() {
        return idCodeValue.charAt(INT24) >= '1' && idCodeValue.charAt(INT24) <= '6';
    }

    /**
     * Check if the year number is correct.
     *
     * @return boolean describing whether the year number is correct.
     */
    private boolean isYearNumberCorrect() {
        int number = INT24;
        char yearnum1 = idCodeValue.charAt(INT25);
        String str1 = Character.toString(yearnum1);
        char yearnum2 = idCodeValue.charAt(INDEX);
        String str2 = Character.toString(yearnum2);
        String fullYear = str1 + str2;
        number = Integer.parseInt(fullYear);
        return INT24 <= number && number <= INT26;
    }

    /**
     * Check if the month number is correct.
     *
     * @return boolean describing whether the month number is correct.
     */
    private boolean isMonthNumberCorrect() {
        int month = INT24;
        char month1 = idCodeValue.charAt(3);
        String str1 = Character.toString(month1);
        char month2 = idCodeValue.charAt(INT35);
        String str2 = Character.toString(month2);
        String fullYear = str1 + str2;
        month = Integer.parseInt(fullYear);
        return INT24 <= month && month <= INT27;
    }


    /**
     * Check if the day number is correct.
     *
     * @return boolean describing whether the day number is correct.
     */
    private boolean isDayNumberCorrect() {
        int day = INT24;
        char day1 = idCodeValue.charAt(5);
        String str12 = Character.toString(day1);
        char day2 = idCodeValue.charAt(6);
        String str13 = Character.toString(day2);
        String fullDay = str12 + str13;
        day = Integer.parseInt(fullDay);
        int month = INT24;
        char month1 = idCodeValue.charAt(3);
        String str1 = Character.toString(month1);
        char month2 = idCodeValue.charAt(INT35);
        String str2 = Character.toString(month2);
        String fullMonth = str1 + str2;
        month = Integer.parseInt(fullMonth);
        int[] thirtyDays = new int[]{INT35, 6, 9, INT};
        int[] thirtyOneDays = new int[]{INT25, 3, 5, 7, 8, INT34, INT27};
        int fullYear = getFullYear();
        boolean gen = isGenderNumberCorrect();
        if (fullYear <= INT28 && fullYear >= INT29 && gen) {
            for (int element: thirtyDays) {
                if (element == month) {
                    return INT25 <= day && INT30 >= day;
                }
            } for (int element: thirtyOneDays) {
                if (element == month) {
                    return INT25 <= day && INT31 >= day;
                }
            } if (isLeapYear(fullYear) && month == INDEX) {
                return INT25 <= day && INT32 >= day;
            } else if (month == INDEX) {
                return INT25 <= day && INT33 >= day;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * Check if the control number is correct.
     *
     * @return boolean describing whether the control number is correct.
     */
    private boolean isControlNumberCorrect() {
        String newId = removeLastChar(idCodeValue);
        System.out.println(newId);
        int[] firstBalance = new int[]{INT25, INDEX, 3, INT35, 5, 6, 7, 8, 9, INT25};
        int[] secondBalance = new int[]{3, INT35, 5, 6, 7, 8, 9, INT25, INDEX, 3};
        int[] newElement = new int[INT34];
        int[] oneElement = new int[INT34];
        char[] result = newId.toCharArray();
        int i = -INT25;
        int y = -INT25;
        System.out.println(result[INT24]);
        for (char element: result) {
            int intElement = Character.getNumericValue(element);
            int myEl = INT24;
            i += INT25;
            y += INT25;
            int num = firstBalance[y];
            myEl = intElement * num;
            newElement[i] = myEl;
        } int sum = INT24;
        for (Integer u : newElement) {
            sum += u;
        }
        System.out.println(sum);
        if (sum % INT == INT34) {
            i = -INT25;
            y = -INT25;
            for (int element: result) {
                int intElement = Character.getNumericValue(element);
                i += INT25;
                y += INT25;
                int num = secondBalance[y];
                int myEl = intElement * num;
                oneElement[i] = myEl;
            } int sum2 = INT24;
            for (Integer u : oneElement) {
                sum2 += u;
            } if (sum2 % INT == INT34) {
                return Character.getNumericValue(idCodeValue.charAt(INT34)) == INT24;
            } else {
                return Character.getNumericValue(idCodeValue.charAt(INT34)) == sum2 % INT;
            }
        } else {
            int val = Character.getNumericValue(idCodeValue.charAt(INT34));
            int val2 = sum % INT;
            return val == val2;
        }
    }

    /**
     * Check if the given year is a leap year.
     *
     * @param fullYear
     * @return boolean describing whether the given year is a leap year.
     */
    private boolean isLeapYear(int fullYear) {
        return fullYear % INT35 == INT24 && fullYear % INT36 != INT24 || fullYear % INT37 == INT24;
    }

    public String getMonth() {
        char month1 = idCodeValue.charAt(3);
        String str1 = Character.toString(month1);
        char month2 = idCodeValue.charAt(INT35);
        String str2 = Character.toString(month2);
        return str1 + str2;
    }

    public String getDay() {
        char month1 = idCodeValue.charAt(5);
        String str1 = Character.toString(month1);
        char month2 = idCodeValue.charAt(6);
        String str2 = Character.toString(month2);
        return str1 + str2;
    }

    public int getNumber() {
        int month = INT24;
        char month1 = idCodeValue.charAt(7);
        String str1 = Character.toString(month1);
        char month2 = idCodeValue.charAt(8);
        String str2 = Character.toString(month2);
        char month3 = idCodeValue.charAt(9);
        String str3 = Character.toString(month3);
        String fullMonth = str1 + str2 + str3;
        month = Integer.parseInt(fullMonth);
        return month;
    }
    /**
     * Run tests.
     * @param args info.
     */

    public static void main(String[] args) {
        IdCode validMaleIdCode = new IdCode("2734983274327432");
        System.out.println(validMaleIdCode.isCorrect());
        System.out.println(validMaleIdCode.getInformation());
        System.out.println(validMaleIdCode.getGender());
        System.out.println(validMaleIdCode.getBirthPlace());
        System.out.println(validMaleIdCode.getFullYear());
        System.out.println(validMaleIdCode.isGenderNumberCorrect());
        System.out.println(validMaleIdCode.isYearNumberCorrect());
        System.out.println(validMaleIdCode.isMonthNumberCorrect());
        System.out.println(validMaleIdCode.isDayNumberCorrect());
        System.out.println(validMaleIdCode.isControlNumberCorrect());
        System.out.println(validMaleIdCode.isLeapYear(validMaleIdCode.getFullYear()));
    }

}
