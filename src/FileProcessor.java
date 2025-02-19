import listprocessing.ProjectServerManager;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FileProcessor {

    private ProjectServerManager serverManager;

    /**
     * Constructor for FileProcessor.
     */
    public FileProcessor() {
        serverManager = new ProjectServerManager();

    }

    /**
     * Returns a {@code `List<String>`} that contains only the file names for .txt or .md files, all lowercase and
     * sorted alphabetically.
     * PARTICIPANTS: Complete this method.
     * @param source Source list.
     * @return Processed list.
     */

//filterDocs() returns a List<String> that contains only the
// file names for .txt and .md files, all lowercase and
// sorted alphabetically.All using stream and lambda expressions.
    public List<String> filterDocs(List<String> source) {

        return source.stream()
                .filter(fileName -> fileName.toLowerCase().endsWith(".txt") || fileName.toLowerCase().endsWith(".md"))
                .map(String::toLowerCase)
                .sorted()
                .collect(Collectors.toList());

        //1.
        //source.stream(): Convert the input list to a stream.
        //2.
        //.filter(fileName -> fileName.endsWith(".txt") ||
        // fileName.endsWith(".md")): Keep only the file names
        // that end with ".txt" or ".md".
        //3.
        //.map(String::toLowerCase): Convert each file name to
        // lowercase.
        //4.
        //.sorted(): Sort the remaining file names alphabetically.

        //5.
        //.collect(Collectors.toList()): Collect the results back
        // into a List.



    }

    /**
     * Returns a {@code `Set<String>`} that contains only the file names for .java files, with each file capitalized.
     * PARTICIPANTS: Complete this method.
     * @param source Source List.
     * @return Processed Set.
     */

    //filterJava() returns a Set<String> that contains only the file names for
    // .java files, with each file capitalized.
    public Set<String> filterJava(List<String> source) {
        return source.stream()
                .filter(fileName -> fileName.toLowerCase().endsWith(".java"))
                .map(String::toUpperCase)
                .collect(Collectors.toSet());

        //1.
        //source.stream(): Convert the input list to a stream.
        //2.
        //.filter(fileName -> fileName.toLowerCase().endsWith(".java")): Keep only the file names
        // that end with ".java".
        //3.
        //.map(String::toUpperCase): Convert each file name to
        // uppercase.

        //4.
        //.collect(Collectors.toSet()): Collect the results back
        // into a Set.

    }

    /**
     * Sorts all file names in the list, and submits them in order to the project server via the method
     * `submitToProject()` of the `listprocessing.ProjectServerManager` class.
     * PARTICIPANTS: Complete this method.
     * @param source Source list.
     */
    //sortAndSubmitAll() sorts all file names in the list, and submits them to
    // the project server via the method submitToProject().

    public void sortAndSubmitAll(List<String> source) {
        List<String> processedList = filterDocs(source);
        processedList.addAll(filterJava(source));
        processedList.sort(String::compareToIgnoreCase);
        processedList.forEach(fileName -> serverManager.submitToProject(fileName));
        serverManager.submitToProject(null); // Submit a null file name to mark the end of the submission process.


        //1.
        //filterDocs(source): Call the filterDocs() method to process the source list.
        //2.
        //filterJava(source): Call the filterJava() method to process the source list.
        //3.
        //processedList.addAll(filterJava(source)): Add the processed Java file names to the processed list.
        //4.
        //processedList.sort(String::compareToIgnoreCase): Sort the processed list alphabetically.
        //5.
        //processedList.forEach(fileName -> serverManager.submitToProject(fileName)): Submit each file name to the project server.

        //6.
        //serverManager.submitToProject(fileName): Submit the file name to the project server.

    }
}
