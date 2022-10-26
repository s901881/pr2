package de.bht.pr2.lab01;

public class Student {

  // -------------------------------------------
  // Attribute
  private String name = "";

  // Matrikelnummer
  private int registrationNumber = 0;

  // Medieninformatik, Technische Informatik, Druck- und Medientechnik und Screen
  // Based Media
  private String courseOfStudies = "";

  // Rückmeldegebühr
  public static final int TUITION_FEE = 312;
  private int bezahlt = 0;

  /**
   * This contructor parses a comma-separated row describing a student object.
   *
   * @param dataRow a comma-separated row describing a student object
   * @throws NotPaidTuitionFeeException
   * @throws WrongCourseOfStudiesException
   * @throws RegistrationNumberException
   * @throws StudentParseException
   */
  public Student(String dataRow)
      throws NotPaidTuitionFeeException, WrongCourseOfStudiesException, RegistrationNumberException, StudentParseException {
    // TODO: Here goes your code ...
        try{

        
    String[] split = dataRow.split(",");
    name = split[0];
      

    // 2 exception von der aufgabe
    try {
      registrationNumber = Integer.parseInt(split[1]);
    } catch (NumberFormatException e) {
      throw new RegistrationNumberException(split[1]);
    }

    courseOfStudies = split[2];
    bezahlt = Integer.parseInt(split[3]);

    // 4 exception von der aufgabe
    if (bezahlt != TUITION_FEE) {
      throw new NotPaidTuitionFeeException(Integer.toString(TUITION_FEE - bezahlt));
    }
    // 3 exception von der aufgabe
    // if(courseOfStudies != "Medieninformatik" && courseOfStudies != "Technische
    // Informatik" && courseOfStudies != "Druck- und Medientechnik" &&
    // courseOfStudies != "Screen Based Media"){
    // throw new WrongCourseOfStudiesException(courseOfStudies);
    // }
    if (!courseOfStudies.equals("Medieninformatik") && !courseOfStudies.equals("Druck- und Medientechnik")
        && !courseOfStudies.equals("Technische Informatik") && !courseOfStudies.equals("Screen Based Media")) {
      throw new WrongCourseOfStudiesException(courseOfStudies);
    }
  }catch(ArrayIndexOutOfBoundsException e){
    throw new StudentParseException(dataRow);
  }
    
  }
  public String toString() {
    String returnString = name
        + " (" + registrationNumber + "), "
        + courseOfStudies;
    return returnString;
  }
}
