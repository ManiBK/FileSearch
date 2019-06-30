public class Searcher {

  private static String filepath = null;
  private static final String defaultPath = "//sample_text";

  private Searcher() {
    this.filepath = defaultPath;
  }

  private Searcher(String dir) {
    if (dir.isEmpty()) {
      this.filepath = defaultPath;
    } else {
      this.filepath = dir;
    }
  }

  public static void main(String[] args) throws IOException {
    Searcher search = new Searcher();

    String folderToSearch = search.filepath;

    File folder = new File(folderToSearch);
    Set<File> list = new HashSet<File>();
    search.getFiles(folder, list);

    String toSearch = "The";
    for (File file : list) {
     BruteForceSearch bSerch = new BruteForceSearch(file);
     bSerch.search(toSearch);
    }
  }

  private void getFiles(File folder, Set<File> list) {

    folder.setReadOnly();
    File[] files = folder.listFiles();
    for (int j = 0; j < files.length; j++) {
      list.add(files[j]);
      if (files[j].isDirectory())
        getFiles(files[j], list);
    }
  }

}

public class BruteForceSearch implements WordSearch{

  private final String fileName;
  private Map<String, Integer> result =  new HashMap<String, Integer>();
  private File file;
  private int count =0;


  public BruteForceSearch(File file) throws IOException {
    this.file =  file;
    this.fileName = file.getName();
    this.count = 0;
  }

  private void searchBruteForce(String toSearch) throws IOException {

      FileInputStream fstream = new FileInputStream(file);
      BufferedReader in = new BufferedReader(new InputStreamReader(fstream));
      String readLine = "";
      while ((readLine = in.readLine()) != null) {
        String[] words = readLine.split("\\W");
        for (String text : words) {
          if (text.equalsIgnoreCase(toSearch)) {
            count++;
          }
        }
      }
      in.close();
  }

  public String getFile() {
    return fileName;
  }

  public int getCount(String word) {
    return count;
  }

  public void search(String toSearch) throws IOException {
    searchBruteForce(toSearch);
    if (getCount(toSearch) != 0) {
        System.out.println(getFile() + " - " + getCount(toSearch) + " matches ");   
    } 
  }
}
public interface WordSearch {

  String getFile();
  int getCount(String term);
}