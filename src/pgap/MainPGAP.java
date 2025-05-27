package pgap;

// import java.util.Arrays; // Not strictly needed for this simplified plan

public class MainPGAP {

	/**
	 * あなたはあるプロジェクトのPMをしています。
	 * プロジェクトのメンバーにはモチベーションが落ちているメンバーがいます。
	 * PMがモチベーションの落ちているメンバーに声をかけるとことでモチベーションが回復します。
	 * またPMが声をかけてモチベーションが回復したメンバーは両隣のメンバーのモチベーションを回復してくれます。
	 * PMが声をかけれる回数が決まってる時、プロジェクトメンバーのモチベーションが落ちていない人数の最大値を求めて下さい。
	 *
	 * @param lines
	 *     配列 0 : "m k" ( m がメンバー数, k が声をかけれる回数 )
	 *     配列 1 : "members ex) ...H..H." ( "." が落ちてるメンバー, "H" が落ちてないメンバー )
	 * @return モチベーションが落ちてない最大人数
	 */
	public static int execution(String[] lines) {
		// Step 1: Parse Input
		String[] firstLineParts = lines[0].split(" ");
		int m = Integer.parseInt(firstLineParts[0]);
		int k = Integer.parseInt(firstLineParts[1]);

		if (m == 0) {
			return 0;
		}

		char[] member_chars = lines[1].toCharArray();
		// Assuming input uses '.' for unmotivated and 'H' for motivated as per example.
		// The plan mentioned "replace '#' with 'H'", but examples use '.'.
		// For now, proceed assuming '.' are the only unmotivated ones.
		// If '#' can appear, specific logic to handle or convert it would be needed here.
		// For example:
		// for (int i = 0; i < member_chars.length; i++) {
		// if (member_chars[i] == '#') {
		// member_chars[i] = '.'; // Or 'H' if '#' means already motivated
		// }
		// }


		int current_total_motivated = 0;
		for (char c : member_chars) {
			if (c == 'H') {
				current_total_motivated++;
			}
		}

		// Early exit if all are motivated or no talks are possible
		if (current_total_motivated == m || k == 0) {
			return current_total_motivated;
		}

		// Step 2: Identify and Count Contiguous Unmotivated Blocks
		int[] block_counts = new int[3]; // block_counts[0] for 1-dot, [1] for 2-dots, [2] for 3-dots
		int current_dot_streak = 0;

		for (int i = 0; i < m; i++) {
			if (member_chars[i] == '.') {
				current_dot_streak++;
				if (current_dot_streak == 3) {
					block_counts[2]++;
					current_dot_streak = 0; // Reset streak after counting a 3-block
				}
			} else { // member_chars[i] == 'H'
				if (current_dot_streak > 0) {
					// current_dot_streak can be 1 or 2 here
					block_counts[current_dot_streak - 1]++;
				}
				current_dot_streak = 0; // Reset streak
			}
		}
		// After the loop, handle any remaining streak
		if (current_dot_streak > 0) { // Remaining streak can be 1 or 2
			block_counts[current_dot_streak - 1]++;
		}

		// Step 3: Greedily Apply Talks to Blocks
		for (int block_size_idx = 2; block_size_idx >= 0; block_size_idx--) {
			if (k == 0) {
				break;
			}
			int actual_block_size = block_size_idx + 1;
			int num_blocks_of_this_size = block_counts[block_size_idx];

			int talks_for_this_block_size = Math.min(k, num_blocks_of_this_size);
			
			current_total_motivated += talks_for_this_block_size * actual_block_size;
			k -= talks_for_this_block_size;
		}
		
		// Step 4: Return current_total_motivated
		return current_total_motivated;
	}
}