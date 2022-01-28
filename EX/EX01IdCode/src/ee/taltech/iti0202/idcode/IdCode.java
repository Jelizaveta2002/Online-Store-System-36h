
package ee.taltech.iti0202.idcode;

public class IdCode {

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
        this.idCodeValue = idCodeValue;
    }

    /**
     * Check if the id code is valid or not.
     *
     * @return boolean describing whether or not the id code was correct.
     */
    public boolean isCorrect() {
        return false;
    }

    /**
     * Get all information about id code.
     *
     * @return String containing information.
     */
    public String getInformation() {
        return null;
    }

    /**
     * Get gender enum.
     *
     * @return enum describing person's gender
     */
    public Gender getGender() {
        if (idCodeValue.charAt(0) % 2 == 0) {
            return Gender.FEMALE;
        }else {
            return Gender.MALE;
        }
    }

    /**
     * Get person's birth location.
     *
     * @return String with the person's birth place.
     */
    public String getBirthPlace() {
        return null;
    }

    /**
     * Get the year that the person was born in.
     *
     * @return int with person's birth year.
     */
    public int getFullYear() {
        char year_num1 = idCodeValue.charAt(1);
        String str1 = Character.toString(year_num1);
        char year_num2 = idCodeValue.charAt(2);
        String str2 = Character.toString(year_num2);
        String full_year = str1 + str2;
        int number = 0;
        if (idCodeValue.charAt(0) == '1' || idCodeValue.charAt(0) == '2') {
            String str = "18" + full_year;
            number = Integer.parseInt(str);
        }else if (idCodeValue.charAt(0) == '3' || idCodeValue.charAt(0) == '4') {
            String str = "19" + full_year;
            number = Integer.parseInt(str);
        }else if (idCodeValue.charAt(0) == '5' || idCodeValue.charAt(0) == '6') {
            String str = "20" + full_year;
            number = Integer.parseInt(str);
        }return number;
    }

    /**
     * Check if gender number is correct.
     *
     * @return boolean describing whether the gender number is correct.
     */
    private boolean isGenderNumberCorrect() {
        return idCodeValue.charAt(0) >= '1' && idCodeValue.charAt(0) <= '6';
    }

    /**
     * Check if the year number is correct.
     *
     * @return boolean describing whether the year number is correct.
     */
    private boolean isYearNumberCorrect() {
        int number = 0;
        char year_num1 = idCodeValue.charAt(1);
        String str1 = Character.toString(year_num1);
        char year_num2 = idCodeValue.charAt(2);
        String str2 = Character.toString(year_num2);
        String full_year = str1 + str2;
        number = Integer.parseInt(full_year);
        System.out.println(number);
        return 0 <= number && number <= 99;
    }

    /**
     * Check if the month number is correct.
     *
     * @return boolean describing whether the month number is correct.
     */
    private boolean isMonthNumberCorrect() {
        int month = 0;
        char month_1 = idCodeValue.charAt(3);
        String str1 = Character.toString(month_1);
        char month_2 = idCodeValue.charAt(4);
        String str2 = Character.toString(month_2);
        String full_year = str1 + str2;
        month = Integer.parseInt(full_year);
        System.out.println(month);
        return 0 <= month && month <= 12;
    }

    /**
     * Check if the day number is correct.
     *
     * @return boolean describing whether the day number is correct.
     */
    private boolean isDayNumberCorrect() {
        int day = 0;
        char day_1 = idCodeValue.charAt(5);
        String str12 = Character.toString(day_1);
        char day_2 = idCodeValue.charAt(6);
        String str13 = Character.toString(day_2);
        String full_day = str12 + str13;
        day = Integer.parseInt(full_day);
        int month = 0;
        char month_1 = idCodeValue.charAt(3);
        String str1 = Character.toString(month_1);
        char month_2 = idCodeValue.charAt(4);
        String str2 = Character.toString(month_2);
        String full_month = str1 + str2;
        month = Integer.parseInt(full_month);
        int[] thirty_days = new int[]{4, 6, 9, 11};
        int[] thirty_one_days = new int[]{1, 3, 5, 7, 8, 10, 12};
        int full_year = getFullYear();
        boolean gen = isGenderNumberCorrect();
        if (full_year <= 2099 && full_year >= 1800 && gen){
            for (int element: thirty_days){
                if (element == month){
                    return 1 <= day && 30 >= day;
                }
            }for (int element: thirty_one_days){
                if (element == month){
                    return 1 <= day && 31 >= day;
                }
            }if(isLeapYear(full_year) && month == 2){
                return 1 <= day && 29 >= day;
            }else if (month == 2){
                return 1 <= day && 28 >= day;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    /**
     * Check if the control number is correct.
     *
     * @return boolean describing whether the control number is correct.
     */
    private boolean isControlNumberCorrect() {
        return false;
    }

    /**
     * Check if the given year is a leap year.
     *
     * @param fullYear
     * @return boolean describing whether the given year is a leap year.
     */
    private boolean isLeapYear(int fullYear) {
//        int number = 0;
//        char year_num1 = idCodeValue.charAt(1);
//        String str1 = Character.toString(year_num1);
//        char year_num2 = idCodeValue.charAt(2);
//        String str2 = Character.toString(year_num2);
//        String full_year = str1 + str2;
//        number = Integer.parseInt(full_year);
        return fullYear % 4 == 0 && fullYear % 100 != 0 || fullYear % 400 == 0;
    }

    /**
     * Run tests.
     * @param args info.
     */
    public static void main(String[] args) {
        IdCode validMaleIdCode = new IdCode("37605030299");
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
