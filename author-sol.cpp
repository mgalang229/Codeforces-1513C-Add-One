#include <bits/stdc++.h>
using namespace std;

const int mod = 1e9 + 7;
const int maxN = 200001;
int dp[maxN];

void test_case(int& tc) {
  int n, m;
  cin >> n >> m;
  int ans = 0;
  while (n > 0) {
    int digit = n % 10;
    ans += ((m + digit < 10 ) ? 1 : dp[m+digit-10]);
    ans %= mod;
    n /= 10;
  }
  cout << ans << "\n";
}

int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  
  for (int i = 0; i < 9; i++)
    dp[i] = 2;
  dp[9] = 3;
  for (int i = 10; i < maxN; i++)
    dp[i] = (dp[i-9] + dp[i-10]) % mod;
  
  int T = 1;
  cin >> T;
  for (int tc = 1; tc <= T; tc++)
    test_case(tc);
}
