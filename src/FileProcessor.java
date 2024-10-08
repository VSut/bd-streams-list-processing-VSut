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
    public List<String> filterDocs(List<String> source) {
        return source.stream().filter(s -> s.endsWith(".txt") || s.endsWith(".md")).map(String::toLowerCase).sorted().toList();
    }

    /**
     * Returns a {@code `Set<String>`} that contains only the file names for .java files, with each file capitalized.
     * PARTICIPANTS: Complete this method.
     * @param source Source List.
     * @return Processed Set.
     */
    public Set<String> filterJava(List<String> source) {
        return source.stream().filter(s -> s.endsWith(".java")).map(s -> {
            return s.substring(0, 1).toUpperCase() + s.substring(1);
        } ).collect(Collectors.toSet());
    }

    /**
     * Sorts all file names in the list, and submits them in order to the project server via the method
     * `submitToProject()` of the `listprocessing.ProjectServerManager` class.
     * PARTICIPANTS: Complete this method.
     * @param source Source list.
     */
    public void sortAndSubmitAll(List<String> source) {
        source.stream().sorted().forEach(serverManager::submitToProject);
    }
}
