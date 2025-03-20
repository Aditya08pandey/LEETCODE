class Solution {
    public List<String> removeSubfolders(String[] folder) {
	// In ASCII, '/' is before 'a': e.g., '/a', '/a/b', '/aa'
	Arrays.sort(folder);
	
	List<String> result = new ArrayList<>();
	
	for (String dir : folder)
		if (result.isEmpty() || !dir.startsWith(result.get(result.size()-1) + "/"))
			result.add(dir);
			
	return result;
}
}