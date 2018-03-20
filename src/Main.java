import java.io.*;

public class Main {


    public static void main (String[] args) throws FileNotFoundException {
        // Open the file
        FileInputStream fstream = null;
        BufferedWriter bw = null;
        File fout = new File("./stocksElasticSearch.json");
        FileOutputStream fos = new FileOutputStream(fout);
        int i = 1;


            bw = new BufferedWriter(new OutputStreamWriter(fos));


        try {
            fstream = new FileInputStream("./stocks.json");
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));


        String strLine;

        //Read File Line By Line
        while ((strLine = br.readLine()) != null)   {

            bw.write("{\"index\":{\"_index\": \"stocks\",\"_type\":\"stock\",\"_id\":" + i + "}}");
            bw.newLine();
            bw.write(strLine);
            bw.newLine();

            i++;
        }

        //Close the input stream
        br.close();
            bw.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }
