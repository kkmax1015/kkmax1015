import java.util.*;
public class template {
  public static void main(String[] args) throws Exception {
    // Scanner
    Scanner sc = null;
    sc = new Scanner(System.in);
    // 数字取得
    int n = Integer.parseInt(sc.next());
    long ｌ = Long.parseLong(sc.next());

    // 文字取得
    String s = sc.next();
    // 行取得
    ArrayList<String> sList = new ArrayList<String>();
    for (int i = 0; i < n; i++) {
      sList.add(sc.next());
    }
    ArrayList<Long> numList = new ArrayList<Long>();
    for (int i = 0; i < n; i++) {
      numList.add(Long.parseLong(sc.next()));
    }

    ArrayList<Integer> intList = new ArrayList<Integer>();
    for (int i = 0; i < n; i++) {
      intList.add(Integer.parseInt(sc.next()));
    }
    sc.close();

    // ソート
    Collections.sort(numList);
    // 降順ソート
    Collections.sort(numList);
    Collections.reverse(numList);

    // 最大値取得
    Collections.max(numList);

    Collections.min(numList);

    // 配列
    ArrayList<Integer> nList = new ArrayList<Integer>();
    ArrayList<Long> lList = new ArrayList<Long>();
    ArrayList<String> strList = new ArrayList<String>();

    // Set(値の重複がない)/検索が高速
    Set<Integer> num = new HashSet<>();
    Set<String> stringSet = new HashSet<>();

    // 累乗
    Math.pow(n, 2);

    // 平方根
    Math.sqrt(n);

    // 大文字判定
    if (Character.isUpperCase(s.charAt(0))) {
      System.out.println("A");
    }

    // 特定の文字を含むか
    if (s.contains("A")) {
      System.out.println("OK");
    }

    // 末尾が特定の文字列に一致するか
    if (s.endsWith("A")) {
      System.out.println("OK");
    }
    // 先頭が特定の文字列に一致するか
    if (s.startsWith("A")) {
      System.out.println("OK");
    }

    // 出力
    System.out.println("Hello, World!");

    //【10進数→n進数】
    //10進数30を16進数に変換
    String s_16 = Integer.toString(30, 16);

    //【n進数→10進数】
    //16進数1eを10進数に変換
    int i1 = Integer.parseInt("1e", 16);

    //【n進数→m進数】
    int n1 = 2;
    int m1 = 8;
    String s1 = Integer.toString(Integer.parseInt("1110", n1), m1);

    // 約数列挙
    for (long i = 1; i * i <= n; i++) {
      if (n % i == 0) {
        numList.add(i);
        if (n / i != i) {
          numList.add(n / i);
        }
      }
    }
    // 3つ以上の数の最大公約数
    long gcd = 0;
    for (int i = 0; i < n; i++) {
      gcd = GCD(gcd, numList.get(i));
    }

    // bit全探索
    // 2N-1までインクリメントすることで部分集合を全探索できる
    long total = 0;
    int[] A = {1, 2, 3, 4, 5};
    for(int bit = 0;bit<Math.pow(2,n);bit++){
      for (int i = 0; i < n; i++) {
        // ビットが立っている場合の処理
        if ((bit >> i & 1) == 1) {
          total += A[i];
        }
      }
    }

  }
  
  // N進数で表したときに特定の値が入っているかをチェック
  private static boolean judgeContainNumber(int x,int base,int jNum) {

    boolean resultFlag = false;
    while(x > 0){
        if(x%base==jNum){
            resultFlag = true;
            break;
        }
        x /= base;
    }

    return resultFlag;
  }
  
  // 最大公約数
  private static long GCD(long a, long b) {
    if (b == 0) {
      return a;
    } else {
      return GCD(b, a % b);
    }
  }
  
  //　素因数分解
  private static Map prime_factorization(long n) {
    Map<Long, Long> res = new HashMap<>();
    for (long i = 2; i * i <= n; ++i) {
      if (n % i != 0)
        continue;
      long ex = 0; // 指数

      // 割れる限り割り続ける
      while (n % i == 0) {
        ++ex;
        n /= i;
      }

      // その結果を push
      res.put((Long) i, (Long) ex);
    }

    // 最後に残った数について
    if (n != 1)
      res.put((Long) n, Long.valueOf(1));
    return res;
  }
  
  // 各桁の和を計算
  private static int findSumOfDigits(int n){
    int sum= 0;
    while(n > 0){
        sum += n%10;
        n /=10;
    }
    return sum;
  }
}
