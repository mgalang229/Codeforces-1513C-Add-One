import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public class OtherSol {
	
	static final long mod = 1_000_000_007;
	static final int maxM = 200_001;
	static long[][] dp;
	
	public static void main(String[] args) {
		prep();
		FastScanner fs = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int T = 1;
		T = fs.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int n = fs.nextInt(), m = fs.nextInt();
			long ans = 0;
			while (n > 0) {
				ans = (ans + dp[n%10][m]) % mod;
				n /= 10;
			}
			out.println(ans);
		}
		out.close();
	}
	
	static void prep() {
		dp = new long[10][maxM];
		for (int digit = 0; digit <= 9; digit++) {
			Arrays.fill(dp[digit], -1);
		}
		for (int digit = 0; digit <= 9; digit++) {
			for (int m = 0; m < maxM; m++) {
				dp[digit][m] = dfs(digit, m);
			}
		}
	}
	
	static long dfs(int digit, int m) {
		if (m == 0) {
			dp[digit][m] = 1;
		}
		if (dp[digit][m] != -1) {
			return dp[digit][m];
		}
		if (digit < 9) {
			dp[digit][m] = dfs(digit + 1, m - 1) % mod;
			return dp[digit][m];
		}
		long value = (dfs(1, m - 1) + dfs(0, m - 1)) % mod;
		dp[digit][m] = value;
		return dp[digit][m];
	}
	
	static final Random rnd = new Random();
	static void shuffleSort(int[] a) { //change this
		int n = a.length;
		for (int i = 0; i < n; i++) {
			int newInd = rnd.nextInt(n);
			int temp = a[newInd]; //change this
			a[newInd] = a[i];
			a[i] = temp;
		}
		Arrays.sort(a);
	}
	
	static class FastScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		
		String next() {
			while (!st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		
		int[] readArray(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextInt();
			}
			return a;
		}
		
		long[] readLongArray(int n) {
			long[] a = new long[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextLong();
			}
			return a;
		}
		
		double[] readDoubleArray(int n) {
			double[] a = new double[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextDouble();
			}
			return a;
		}
		
		long nextLong() {
			return Long.parseLong(next());
		}
		
		double nextDouble() {
			return Double.parseDouble(next());
		}
		
		String nextLine() {
			String str = "";
			try {
				if (st.hasMoreTokens()) {
					str = st.nextToken("\n");
				} else {
					str = br.readLine();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
