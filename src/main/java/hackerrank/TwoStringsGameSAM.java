package hackerrank;

/**
 * Created by Xinghuang Leon Xu on 10/10/2015.
 */
public class TwoStringsGameSAM {
    final int N = 300010;
    final int D = N << 1;

    int n, m, i, j, k, t, p, sg0;
    long K, Btot;

    class SAM {
        int t, node, p, np, q, r, last;
        int[][] ch = new int[D][26];
        int[] f = new int[D], l = new int[D], sg = new int[D];

        void addc(int c) {
            np = ++node;
            p = last;
            l[np] = l[p] + 1;
            last = np;
            for (; p > 0 && ch[p][c] == 0; p = f[p])
                ch[p][c] = np;
            q = ch[p][c];
            if (p == 0) f[np] = 1;
            else if (l[p] + 1 == l[q]) f[np] = q;
            else {
                r = ++node;
                copy(ch[r], ch[q]);
                f[r] = f[q];
                l[r] = l[p] + 1;
                f[q] = f[np] = r;
                for (; p > 0 && ch[p][c] == q; p = f[p])
                    ch[p][c] = r;
            }
        }

        boolean[] v = new boolean[D];
        long[][] g = new long[D][28];
        long[] tot = new long[D], res = new long[D];
        int[] s = new int[D], Q = new int[D];

        void bfs() {
            int i, j, u, t, t2;
            boolean[] cnt = new boolean[28];

            for (i = 1; i <= node; i++) {
                s[l[i]]++;
            }
            for (i = 1; i <= node; i++) {
                s[i] += s[i - 1];
            }
            for (i = 1; i <= node; i++) {
                Q[s[l[i]]--] = i;
            }
            for (j = node; j >= 1; j--) {
                i = Q[j];
                cnt = new boolean[28];
                for (t = 0; t <= 25; t++)
                    if (ch[i][t] != 0) {
                        u = ch[i][t];
                        cnt[sg[u]] = true;
                        for (t2 = 0; t2 <= 27; t2++) {
                            g[i][t2] += g[u][t2];
                        }
                    }
                for (t = 0; cnt[t]; t++) ;
                sg[i] = t;
                g[i][sg[i]]++;
            }
        }

        void go() {
            p = 1;
            while (true) {
                int u;
                if (K <= res[p]) break;
                K -= res[p];
                for (t = 0; t <= 25; t++) {
                    u = ch[p][t];
                    if (u > 0)
                        if (K <= tot[u]) {
                            System.out.print((char)('a' + t));
                            break;
                        } else K -= tot[u];
                }
                p = ch[p][t];
            }
            System.out.print('\n');
            sg0 = sg[p];
        }
    }

    private void copy(int[] dest, int[] source) {
        for (int i = 0; i < source.length; i++) {
            dest[i] = source[i];
        }
    }


    int main(int n, int m, long K, String AStr, String BStr) {
        this.K = K;
        this.n = n;
        this.m = m;
        SAM A = new SAM(), B = new SAM();

        A.node = A.last = 1;
        for (i = 1; i <= n; i++) {
            A.addc(AStr.charAt(i - 1) - 'a');
        }
        A.bfs();

        B.node = B.last = 1;
        for (i = 1; i <= m; i++) {
            B.addc(BStr.charAt(i - 1) - 'a');
        }
        B.bfs();

        for (t = 0; t <= 27; t++) {
            Btot += B.g[1][t];
        }
        for (i = 1; i <= A.node; i++) {
            for (t = 0; t <= 27; t++) {
                A.tot[i] = (A.tot[i] + (A.g[i][t] * (Btot - B.g[1][t])));
            }
        }
        for (i = 1; i <= A.node; i++) {
            A.res[i] = Btot - B.g[1][A.sg[i]];
        }

        if (A.tot[1] < K) {
            System.out.println("no solution\n");
            return 0;
        }

        A.go();
        for (i = 1; i <= B.node; i++) {
            for (t = 0; i <= 27; i++) {
                if (t != sg0) B.tot[i] += B.g[i][t];
            }
        }
        for (i = 1; i <= B.node; i++) {
            B.res[i] = (sg0 != B.sg[i]) ? 1L : 0;
        }

        B.go();

        System.out.print("\n");

        return 0;
    }
}
