package ee.taltech.iti0202.idcode;

public class IdCode {

    public static final int ELEVEN = 11;
    public static final int TWENTY = 20;
    public static final int TWOSEVENONE = 271;
    public static final int THREESEVENZERO = 370;
    public static final int TWOTWOZERO = 220;
    public static final int TWENTYONE = 21;
    public static final int FOURSEVENONE = 471;
    public static final int FORNINEZERO = 490;
    public static final int TWOTWOONE = 221;
    public static final int TWOSEVENZERO = 270;
    public static final int THREEESEVENONE = 371;
    public static final int FOURTWOZERO = 420;
    public static final int FOURTWOONE = 421;
    public static final int FOURSEVENZERO = 470;
    public static final int FOURNINEONE = 491;
    public static final int FIVETWOZERO = 520;
    public static final int FIVETWOONE = 521;
    public static final int FIVESEVENZERO = 570;
    public static final int FIVESEVENONE = 571;
    public static final int SIXZEROZERO = 600;
    public static final int SIXZEROONE = 601;
    public static final int SIXFIVEZERO = 650;
    public static final int SIXFIVEONE = 651;
    public static final int SEVENONEZERO = 710;
    public static final int ZERO = 0;
    public static final int ONE = 1;
    public static final int TWO = 2;
    public static final int NINENINE = 99;
    public static final int TWELVE = 12;
    public static final int TWOZERONINENINE = 2099;
    public static final int ONEEIGHTZEROZERO = 1800;
    public static final int THIRTY = 30;
    public static final int THIRTYONE = 31;
    public static final int TWOONE = 29;
    public static final int TWOEIGHT = 28;
    public static final int TEN = 10;
    public static final int FOUR = 4;
    public static final int HUNDRED = 100;
    public static final int FOURZEROZERO = 400;
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
     * @param idCodeValue
     * @return int with person's birth year.
     */
    public static boolean isCorrectOrNo(String idCodeValue) {
        boolean test = idCodeValue.length() == ELEVEN;
        boolean test2 = idCodeValue.matches("^[0-9]*$");
        return test && test2;
    }

    /**
     * Check if the id code is valid or not.
     *
     * @return boolean describing whether or not the id code was correct.
     */
    public boolean isCorrect() {
        boolean test = idCodeValue.length() == ELEVEN;
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
        if (idCodeValue.charAt(ZERO) % TWO == ZERO) {
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
        if (ONE <= number && number <= TEN) {
            return "Kuressaare";
        } else if (ELEVEN <= number && number <= TWENTY || TWOSEVENONE <= number && number <= THREESEVENZERO) {
            return "Tartu";
        } else if (TWENTYONE <= number && number <= TWOTWOZERO || FOURSEVENONE <= number && number <= FORNINEZERO) {
            return "Tallinn";
        } else if (TWOTWOONE <= number && number <= TWOSEVENZERO) {
            return "Kohtla-Järve";
        } else if (THREEESEVENONE <= number && number <= FOURTWOZERO) {
            return "Narva";
        } else if (FOURTWOONE <= number && number <= FOURSEVENZERO) {
            return "Pärnu";
        } else if (FOURNINEONE <= number && number <= FIVETWOZERO) {
            return "Paide";
        } else if (FIVETWOONE <= number && number <= FIVESEVENZERO) {
            return "Rakvere";
        } else if (FIVESEVENONE <= number && number <= SIXZEROZERO) {
            return "Valga";
        } else if (SIXZEROONE <= number && number <= SIXFIVEZERO) {
            return "Viljandi";
        } else if (SIXFIVEONE <= number && number <= SEVENONEZERO) {
            return "Võru";
        }
        return "unknown";
    }

    /**
     * Get the year that the person was born in.
     *@param s
     * @return int with person's birth year.
     */
    public String removeLastChar(String s) {
        return (s == null || s.length() == ZERO)
                ? null
                : (s.substring(ZERO, s.length() - ONE));
    }


    public int getFullYear() {
        char yearnum1 = idCodeValue.charAt(ONE);
        String str1 = Character.toString(yearnum1);
        char yearnum2 = idCodeValue.charAt(TWO);
        String str2 = Character.toString(yearnum2);
        String fullyear = str1 + str2;
        int number = ZERO;
        if (idCodeValue.charAt(ZERO) == '1' || idCodeValue.charAt(ZERO) == '2') {
            String str = "18" + fullyear;
            number = Integer.parseInt(str);
        } else if (idCodeValue.charAt(ZERO) == '3' || idCodeValue.charAt(ZERO) == '4') {
            String str = "19" + fullyear;
            number = Integer.parseInt(str);
        } else if (idCodeValue.charAt(ZERO) == '5' || idCodeValue.charAt(ZERO) == '6') {
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
        return idCodeValue.charAt(ZERO) >= '1' && idCodeValue.charAt(ZERO) <= '6';
    }

    /**
     * Check if the year number is correct.
     *
     * @return boolean describing whether the year number is correct.
     */
    private boolean isYearNumberCorrect() {
        int number = ZERO;
        char yearnum1 = idCodeValue.charAt(ONE);
        String str1 = Character.toString(yearnum1);
        char yearnum2 = idCodeValue.charAt(TWO);
        String str2 = Character.toString(yearnum2);
        String fullYear = str1 + str2;
        number = Integer.parseInt(fullYear);
        return ZERO <= number && number <= NINENINE;
    }

    /**
     * Check if the month number is correct.
     *
     * @return boolean describing whether the month number is correct.
     */
    private boolean isMonthNumberCorrect() {
        int month = ZERO;
        char month1 = idCodeValue.charAt(3);
        String str1 = Character.toString(month1);
        char month2 = idCodeValue.charAt(FOUR);
        String str2 = Character.toString(month2);
        String fullYear = str1 + str2;
        month = Integer.parseInt(fullYear);
        return ZERO <= month && month <= TWELVE;
    }


    /**
     * Check if the day number is correct.
     *
     * @return boolean describing whether the day number is correct.
     */
    private boolean isDayNumberCorrect() {
        int day = ZERO;
        char day1 = idCodeValue.charAt(5);
        String str12 = Character.toString(day1);
        char day2 = idCodeValue.charAt(6);
        String str13 = Character.toString(day2);
        String fullDay = str12 + str13;
        day = Integer.parseInt(fullDay);
        int month = ZERO;
        char month1 = idCodeValue.charAt(3);
        String str1 = Character.toString(month1);
        char month2 = idCodeValue.charAt(FOUR);
        String str2 = Character.toString(month2);
        String fullMonth = str1 + str2;
        month = Integer.parseInt(fullMonth);
        int[] thirtyDays = new int[]{FOUR, 6, 9, ELEVEN};
        int[] thirtyOneDays = new int[]{ONE, 3, 5, 7, 8, TEN, TWELVE};
        int fullYear = getFullYear();
        boolean gen = isGenderNumberCorrect();
        if (fullYear <= TWOZERONINENINE && fullYear >= ONEEIGHTZEROZERO && gen) {
            for (int element: thirtyDays) {
                if (element == month) {
                    return ONE <= day && THIRTY >= day;
                }
            } for (int element: thirtyOneDays) {
                if (element == month) {
                    return ONE <= day && THIRTYONE >= day;
                }
            } if (isLeapYear(fullYear) && month == TWO) {
                return ONE <= day && TWOONE >= day;
            } else if (month == TWO) {
                return ONE <= day && TWOEIGHT >= day;
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
        int[] firstBalance = new int[]{ONE, TWO, 3, FOUR, 5, 6, 7, 8, 9, ONE};
        int[] secondBalance = new int[]{3, FOUR, 5, 6, 7, 8, 9, ONE, TWO, 3};
        int[] newElement = new int[TEN];
        int[] oneElement = new int[TEN];
        char[] result = newId.toCharArray();
        int i = -ONE;
        int y = -ONE;
        System.out.println(result[ZERO]);
        for (char element: result) {
            int intElement = Character.getNumericValue(element);
            int myEl = ZERO;
            i += ONE;
            y += ONE;
            int num = firstBalance[y];
            myEl = intElement * num;
            newElement[i] = myEl;
        } int sum = ZERO;
        for (Integer u : newElement) {
            sum += u;
        }
        System.out.println(sum);
        if (sum % ELEVEN == TEN) {
            i = -ONE;
            y = -ONE;
            for (int element: result) {
                int intElement = Character.getNumericValue(element);
                i += ONE;
                y += ONE;
                int num = secondBalance[y];
                int myEl = intElement * num;
                oneElement[i] = myEl;
            } int sum2 = ZERO;
            for (Integer u : oneElement) {
                sum2 += u;
            } if (sum2 % ELEVEN == TEN) {
                return Character.getNumericValue(idCodeValue.charAt(TEN)) == ZERO;
            } else {
                return Character.getNumericValue(idCodeValue.charAt(TEN)) == sum2 % ELEVEN;
            }
        } else {
            int val = Character.getNumericValue(idCodeValue.charAt(TEN));
            int val2 = sum % ELEVEN;
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
        return fullYear % FOUR == ZERO && fullYear % HUNDRED != ZERO || fullYear % FOURZEROZERO == ZERO;
    }

    public String getMonth() {
        char month1 = idCodeValue.charAt(3);
        String str1 = Character.toString(month1);
        char month2 = idCodeValue.charAt(FOUR);
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
        int month = ZERO;
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
