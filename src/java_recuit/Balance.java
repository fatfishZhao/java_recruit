package java_recuit;

public class Balance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] output = solve(10086);
		for(int i=0;i<20;i++){
			if(output[0][0]==0) {
				System.out.println("empty");
				break;
			}
			if(output[0][i]!=0)
				System.out.print(output[0][i]+" ");
			else{
				System.out.println("");
				break;
			}
		}
		for(int i=0;i<20;i++){
			if(output[1][0]==0) {
				System.out.println("empty");
				break;
			}
			if(output[1][i]!=0)
				System.out.print(output[1][i]+" ");
			else{
				System.out.println("");
				break;
			}
		}
		

	}

	public static int[][] solve(int x) {
	    int pl = 0, pr = 0;
	    int poise = 1, r;
	    final int LEFT = 0, RIGHT = 1;
	    int[][] result = new int[2][20];

	    while (x > 0) {
	        r = x % 5;
	        if (r == 4) {
	            result[LEFT][pl++] = poise;
	            x = (x + 1) / 5;
	        }   
	        else if (r == 3) {
	            result[LEFT][pl++] = poise;
	            result[LEFT][pl++] = poise;
	            x = (x + 2) / 5;
	        }
	        else if (r == 2) {
	            result[RIGHT][pr++] = poise;
	            result[RIGHT][pr++] = poise;
	            x = x / 5;
	        }
	        else if (r == 1) {
	            result[RIGHT][pr++] = poise;
	            x = x / 5;
	        }
	        else
	            x = x / 5;

	        poise *= 5;
	    }

	    return result;
	}

}
