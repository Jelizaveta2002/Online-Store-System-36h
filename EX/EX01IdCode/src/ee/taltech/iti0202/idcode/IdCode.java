
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
        System.out.println(idCodeValue.charAt(1));
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
        System.out.println(full_year);
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
        if (idCodeValue.charAt(0) >= '1' && idCodeValue.charAt(0) <= '6'){
            return true;
        }else {
            return false;
        }
    }

    /**
     * Check if the year number is correct.
     *
     * @return boolean describing whether the year number is correct.
     */
    private boolean isYearNumberCorrect() {
        return false;
    }

    /**
     * Check if the month number is correct.
     *
     * @return boolean describing whether the month number is correct.
     */
    private boolean isMonthNumberCorrect() {
        return false;
    }

    /**
     * Check if the day number is correct.
     *
     * @return boolean describing whether the day number is correct.
     */
    private boolean isDayNumberCorrect() {
        return false;
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
        return false;
    }

    /**
     * Run tests.
     * @param args info.
     */
    public static void main(String[] args) {
        IdCode validMaleIdCode = new IdCode("87605030299");
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
