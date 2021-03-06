package com.travelzen.datastructure.algorithm;

/*爬楼梯问题:
一段楼梯共n级台阶，每次只能走一级、两级或三级台阶，问共有多少种走法？列出n=10时的所有走法。
分析：
首先考虑第一步的走法：第一步可以跨1级台阶，也可以跨2级和3级台阶。设S(n)表示走n级台阶的走法数量。如果第一步跨1级台阶，剩下的台阶数为n- 1, 也就是说这种情况下（即第一步跨1级台阶的）走法相当于S(n-1)；如果第一步跨2级台阶，剩下的台阶数为n-2，也就是说如果第一步跨2级台阶的走法 相当于S(n-2)；如果第一步跨3级台阶，剩下的台阶数为n-3，也就是说如果第一步跨3级台阶的走法相当于S(n-3)。从而得到递推关系式：

********************************
S(n) = S(n-1) + S(n-2) + S(n-3)
********************************

如何确定初始值？如果台阶数n=1，显然S(n)=1；如果n=2，走法有(1-1)和(2)两种；如果n=3，走法有(1-1-1)，(1-2),(2-1)和(3)。所以：
********************************
S(1) = 1, S(2) = 2, S(3) = 4
********************************
延伸思考: 如果题目规定每次只能走1级或2级台阶，S(n)与Fibonacci数的关系为：S(n) = F(n+1)。
下面的实现未使用递归，而是采用动态规划的做法。从而提高了程序的执行性能。
?*/
/**
 * 
 * @author ljs
 * 2011-05-30
 * 
 *
 */
public class ClimbingStairs {
    public static void solve(int numOfStairSteps){
        long f1=1;
        long f2=2;
        long f3=4;
        long f = 0;
         
        int[][] steps1 = {{1}};
        int[][] steps2 = {{1,1},{2}};
        int[][] steps3 = {{1,1,1},{1,2},{2,1},{3}};
        int[][] steps= null;
         
        switch(numOfStairSteps){
        case 1:         
            f = f1;
            steps = steps1;
            break;
        case 2:         
            f = f2;
            steps = steps2;
            break;
        case 3:
            f = f3;
            steps = steps3;
            break;
        default:
            int n= 4;           
            while(n<=numOfStairSteps){
                f = f1+f2+f3;
                f1=f2;
                f2=f3;
                f3=f;   
                 
                if(numOfStairSteps<=10){
                    int[][] stepsA = addStep(3,steps1);
                    int[][] stepsB = addStep(2,steps2);
                    int[][] stepsC = addStep(1,steps3);
                    steps = unionSets(stepsA,stepsB,stepsC);
                             
                     
                    steps1 = steps2;
                    steps2 = steps3;
                    steps3 = steps;     
                }
                 
                n++;
            }
            break;
        }       
         
        System.out.format("Total number of ways when steps=%d: %d%n",numOfStairSteps,f);
        if(numOfStairSteps<=10){
            System.out.format("They are: %n");
            printClimbings(steps);
        }
    }
     
    private static void printClimbings(int[][] steps){      
        for(int k=0;k<steps.length;k++){     
            System.out.format("%d: (",k+1);
            for(int m=0;m<steps[k].length-1;m++){
                System.out.format("%d-",steps[k][m]);
            }
            System.out.format("%d)%n",steps[k][steps[k].length-1]);
        }
    }
    private static int[][] addStep(int i,int[][] steps){    
        int[][] ways= new int[steps.length][];
        for(int k=0;k<steps.length;k++){
            int[] way = new int[steps[k].length+1];
            ways[k] = way;
            way[0] = i;
            for(int j=0;j<steps[k].length;j++){
                way[j+1] = steps[k][j];
            }
        }
        return ways;
    }
     
    private static int[][] unionSets(int[][] A,int[][] B,int[][] C){
        int[][] aggregates= new int[A.length+B.length+C.length][];
        int m = 0;
        for(int k=0;k<A.length;k++){
            aggregates[m++] = A[k];
        }
        for(int k=0;k<B.length;k++){
            aggregates[m++] = B[k];
        }
        for(int k=0;k<C.length;k++){
            aggregates[m++] = C[k];
        }
        return aggregates;
    }
     
    public static void main(String[] args) {
        int n = 10;
        ClimbingStairs.solve(n);        
         
        n = 100;
        ClimbingStairs.solve(n);        
    }
}
/*测试：
Total number of ways when steps=10: 274
They are: 
1: (3-3-3-1)
2: (3-3-2-1-1)
3: (3-3-2-2)
4: (3-3-1-1-1-1)
5: (3-3-1-1-2)
6: (3-3-1-2-1)
7: (3-3-1-3)
8: (3-2-3-1-1)
9: (3-2-3-2)
10: (3-2-2-1-1-1)
11: (3-2-2-1-2)
12: (3-2-2-2-1)
13: (3-2-2-3)
14: (3-2-1-3-1)
15: (3-2-1-2-1-1)
16: (3-2-1-2-2)
17: (3-2-1-1-1-1-1)
18: (3-2-1-1-1-2)
19: (3-2-1-1-2-1)
20: (3-2-1-1-3)
21: (3-1-3-1-1-1)
22: (3-1-3-1-2)
23: (3-1-3-2-1)
24: (3-1-3-3)
25: (3-1-2-3-1)
26: (3-1-2-2-1-1)
27: (3-1-2-2-2)
28: (3-1-2-1-1-1-1)
29: (3-1-2-1-1-2)
30: (3-1-2-1-2-1)
31: (3-1-2-1-3)
32: (3-1-1-3-1-1)
33: (3-1-1-3-2)
34: (3-1-1-2-1-1-1)
35: (3-1-1-2-1-2)
36: (3-1-1-2-2-1)
37: (3-1-1-2-3)
38: (3-1-1-1-3-1)
39: (3-1-1-1-2-1-1)
40: (3-1-1-1-2-2)
41: (3-1-1-1-1-1-1-1)
42: (3-1-1-1-1-1-2)
43: (3-1-1-1-1-2-1)
44: (3-1-1-1-1-3)
45: (2-3-3-1-1)
46: (2-3-3-2)
47: (2-3-2-1-1-1)
48: (2-3-2-1-2)
49: (2-3-2-2-1)
50: (2-3-2-3)
51: (2-3-1-3-1)
52: (2-3-1-2-1-1)
53: (2-3-1-2-2)
54: (2-3-1-1-1-1-1)
55: (2-3-1-1-1-2)
56: (2-3-1-1-2-1)
57: (2-3-1-1-3)
58: (2-2-3-1-1-1)
59: (2-2-3-1-2)
60: (2-2-3-2-1)
61: (2-2-3-3)
62: (2-2-2-3-1)
63: (2-2-2-2-1-1)
64: (2-2-2-2-2)
65: (2-2-2-1-1-1-1)
66: (2-2-2-1-1-2)
67: (2-2-2-1-2-1)
68: (2-2-2-1-3)
69: (2-2-1-3-1-1)
70: (2-2-1-3-2)
71: (2-2-1-2-1-1-1)
72: (2-2-1-2-1-2)
73: (2-2-1-2-2-1)
74: (2-2-1-2-3)
75: (2-2-1-1-3-1)
76: (2-2-1-1-2-1-1)
77: (2-2-1-1-2-2)
78: (2-2-1-1-1-1-1-1)
79: (2-2-1-1-1-1-2)
80: (2-2-1-1-1-2-1)
81: (2-2-1-1-1-3)
82: (2-1-3-3-1)
83: (2-1-3-2-1-1)
84: (2-1-3-2-2)
85: (2-1-3-1-1-1-1)
86: (2-1-3-1-1-2)
87: (2-1-3-1-2-1)
88: (2-1-3-1-3)
89: (2-1-2-3-1-1)
90: (2-1-2-3-2)
91: (2-1-2-2-1-1-1)
92: (2-1-2-2-1-2)
93: (2-1-2-2-2-1)
94: (2-1-2-2-3)
95: (2-1-2-1-3-1)
96: (2-1-2-1-2-1-1)
97: (2-1-2-1-2-2)
98: (2-1-2-1-1-1-1-1)
99: (2-1-2-1-1-1-2)
100: (2-1-2-1-1-2-1)
101: (2-1-2-1-1-3)
102: (2-1-1-3-1-1-1)
103: (2-1-1-3-1-2)
104: (2-1-1-3-2-1)
105: (2-1-1-3-3)
106: (2-1-1-2-3-1)
107: (2-1-1-2-2-1-1)
108: (2-1-1-2-2-2)
109: (2-1-1-2-1-1-1-1)
110: (2-1-1-2-1-1-2)
111: (2-1-1-2-1-2-1)
112: (2-1-1-2-1-3)
113: (2-1-1-1-3-1-1)
114: (2-1-1-1-3-2)
115: (2-1-1-1-2-1-1-1)
116: (2-1-1-1-2-1-2)
117: (2-1-1-1-2-2-1)
118: (2-1-1-1-2-3)
119: (2-1-1-1-1-3-1)
120: (2-1-1-1-1-2-1-1)
121: (2-1-1-1-1-2-2)
122: (2-1-1-1-1-1-1-1-1)
123: (2-1-1-1-1-1-1-2)
124: (2-1-1-1-1-1-2-1)
125: (2-1-1-1-1-1-3)
126: (1-3-3-1-1-1)
127: (1-3-3-1-2)
128: (1-3-3-2-1)
129: (1-3-3-3)
130: (1-3-2-3-1)
131: (1-3-2-2-1-1)
132: (1-3-2-2-2)
133: (1-3-2-1-1-1-1)
134: (1-3-2-1-1-2)
135: (1-3-2-1-2-1)
136: (1-3-2-1-3)
137: (1-3-1-3-1-1)
138: (1-3-1-3-2)
139: (1-3-1-2-1-1-1)
140: (1-3-1-2-1-2)
141: (1-3-1-2-2-1)
142: (1-3-1-2-3)
143: (1-3-1-1-3-1)
144: (1-3-1-1-2-1-1)
145: (1-3-1-1-2-2)
146: (1-3-1-1-1-1-1-1)
147: (1-3-1-1-1-1-2)
148: (1-3-1-1-1-2-1)
149: (1-3-1-1-1-3)
150: (1-2-3-3-1)
151: (1-2-3-2-1-1)
152: (1-2-3-2-2)
153: (1-2-3-1-1-1-1)
154: (1-2-3-1-1-2)
155: (1-2-3-1-2-1)
156: (1-2-3-1-3)
157: (1-2-2-3-1-1)
158: (1-2-2-3-2)
159: (1-2-2-2-1-1-1)
160: (1-2-2-2-1-2)
161: (1-2-2-2-2-1)
162: (1-2-2-2-3)
163: (1-2-2-1-3-1)
164: (1-2-2-1-2-1-1)
165: (1-2-2-1-2-2)
166: (1-2-2-1-1-1-1-1)
167: (1-2-2-1-1-1-2)
168: (1-2-2-1-1-2-1)
169: (1-2-2-1-1-3)
170: (1-2-1-3-1-1-1)
171: (1-2-1-3-1-2)
172: (1-2-1-3-2-1)
173: (1-2-1-3-3)
174: (1-2-1-2-3-1)
175: (1-2-1-2-2-1-1)
176: (1-2-1-2-2-2)
177: (1-2-1-2-1-1-1-1)
178: (1-2-1-2-1-1-2)
179: (1-2-1-2-1-2-1)
180: (1-2-1-2-1-3)
181: (1-2-1-1-3-1-1)
182: (1-2-1-1-3-2)
183: (1-2-1-1-2-1-1-1)
184: (1-2-1-1-2-1-2)
185: (1-2-1-1-2-2-1)
186: (1-2-1-1-2-3)
187: (1-2-1-1-1-3-1)
188: (1-2-1-1-1-2-1-1)
189: (1-2-1-1-1-2-2)
190: (1-2-1-1-1-1-1-1-1)
191: (1-2-1-1-1-1-1-2)
192: (1-2-1-1-1-1-2-1)
193: (1-2-1-1-1-1-3)
194: (1-1-3-3-1-1)
195: (1-1-3-3-2)
196: (1-1-3-2-1-1-1)
197: (1-1-3-2-1-2)
198: (1-1-3-2-2-1)
199: (1-1-3-2-3)
200: (1-1-3-1-3-1)
201: (1-1-3-1-2-1-1)
202: (1-1-3-1-2-2)
203: (1-1-3-1-1-1-1-1)
204: (1-1-3-1-1-1-2)
205: (1-1-3-1-1-2-1)
206: (1-1-3-1-1-3)
207: (1-1-2-3-1-1-1)
208: (1-1-2-3-1-2)
209: (1-1-2-3-2-1)
210: (1-1-2-3-3)
211: (1-1-2-2-3-1)
212: (1-1-2-2-2-1-1)
213: (1-1-2-2-2-2)
214: (1-1-2-2-1-1-1-1)
215: (1-1-2-2-1-1-2)
216: (1-1-2-2-1-2-1)
217: (1-1-2-2-1-3)
218: (1-1-2-1-3-1-1)
219: (1-1-2-1-3-2)
220: (1-1-2-1-2-1-1-1)
221: (1-1-2-1-2-1-2)
222: (1-1-2-1-2-2-1)
223: (1-1-2-1-2-3)
224: (1-1-2-1-1-3-1)
225: (1-1-2-1-1-2-1-1)
226: (1-1-2-1-1-2-2)
227: (1-1-2-1-1-1-1-1-1)
228: (1-1-2-1-1-1-1-2)
229: (1-1-2-1-1-1-2-1)
230: (1-1-2-1-1-1-3)
231: (1-1-1-3-3-1)
232: (1-1-1-3-2-1-1)
233: (1-1-1-3-2-2)
234: (1-1-1-3-1-1-1-1)
235: (1-1-1-3-1-1-2)
236: (1-1-1-3-1-2-1)
237: (1-1-1-3-1-3)
238: (1-1-1-2-3-1-1)
239: (1-1-1-2-3-2)
240: (1-1-1-2-2-1-1-1)
241: (1-1-1-2-2-1-2)
242: (1-1-1-2-2-2-1)
243: (1-1-1-2-2-3)
244: (1-1-1-2-1-3-1)
245: (1-1-1-2-1-2-1-1)
246: (1-1-1-2-1-2-2)
247: (1-1-1-2-1-1-1-1-1)
248: (1-1-1-2-1-1-1-2)
249: (1-1-1-2-1-1-2-1)
250: (1-1-1-2-1-1-3)
251: (1-1-1-1-3-1-1-1)
252: (1-1-1-1-3-1-2)
253: (1-1-1-1-3-2-1)
254: (1-1-1-1-3-3)
255: (1-1-1-1-2-3-1)
256: (1-1-1-1-2-2-1-1)
257: (1-1-1-1-2-2-2)
258: (1-1-1-1-2-1-1-1-1)
259: (1-1-1-1-2-1-1-2)
260: (1-1-1-1-2-1-2-1)
261: (1-1-1-1-2-1-3)
262: (1-1-1-1-1-3-1-1)
263: (1-1-1-1-1-3-2)
264: (1-1-1-1-1-2-1-1-1)
265: (1-1-1-1-1-2-1-2)
266: (1-1-1-1-1-2-2-1)
267: (1-1-1-1-1-2-3)
268: (1-1-1-1-1-1-3-1)
269: (1-1-1-1-1-1-2-1-1)
270: (1-1-1-1-1-1-2-2)
271: (1-1-1-1-1-1-1-1-1-1)
272: (1-1-1-1-1-1-1-1-2)
273: (1-1-1-1-1-1-1-2-1)
274: (1-1-1-1-1-1-1-3)
Total number of ways when steps=100: 7367864567128947527*/