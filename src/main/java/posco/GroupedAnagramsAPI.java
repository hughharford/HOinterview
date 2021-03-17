package posco;

import java.util.List;

public interface GroupedAnagramsAPI {

	int getNoGroupedAnagrams();
	void input(List<String> words);
	
	// to follow:
	// List<List<String>> getAnagramGroups();
}
