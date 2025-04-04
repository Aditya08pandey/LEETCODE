class Solution {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder sb = new StringBuilder();
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> y[1] - x[1]);
        pq.add(new int[] {0, a}); pq.add(new int[] {1, b}); pq.add(new int[] {2, c});

    while (true) {

	int[] most = pq.poll();
	int N = sb.length();
	char ch = (char) (most[0] + 'a');

	if (most[1] == 0) break;  

	if (N < 2 || (sb.charAt(N - 2) != ch || sb.charAt(N - 1) != ch)) {
		sb.append(ch);
		--most[1];
	} else {  

		if (pq.peek()[1] == 0) break;  

		int[] secondMost = pq.poll();

		ch = (char) (secondMost[0] + 'a');
		sb.append(ch);
		--secondMost[1];
		pq.add(secondMost);
	}

	pq.add(most);

    }

    return sb.toString();
}
}