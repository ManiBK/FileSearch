Scanner s = new Scanner(new File("abc.txt"));
while(s.hasNextLine()){
    //read the file line by line
String nextLine = s.nextLine();
            //check if the next line contains the key word
    if(nextLine.contains("keyword"))
    {
              //whatever you want to do when the keyword is found in the file
               and break after the first occurance is found
             break;
    }
}