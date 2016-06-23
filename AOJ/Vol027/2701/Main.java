import java.util.Scanner;

public class Main{
    static int H;
    static int N;
    static int max = -1;
    static int tmpMax = 0;
    static boolean[][][] block;

    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	while(true){
	    H = sc.nextInt();
	    N = sc.nextInt();
	    tmpMax = 0;
	    max = -1;
	    if(H == 0 && N == 0){
		break;
	    }
	    boolean field[][] = new boolean[H+7][4];
	    block = new boolean[N][2][4];

	    for(int i=0;i<H;i++){
		for(int j=0;j<2;j++){
		    String str = sc.next();
		    field[i][j*2] = str.charAt(0) == '#';
		    field[i][1+j*2] = str.charAt(1) == '#';
		}
	    }
	    for(int i=0;i<N;i++){
		for(int j=0;j<2;j++){
		    String str = sc.next();
		    block[i][0][j*2] = str.charAt(0) == '#';
		    block[i][0][1+j*2] = str.charAt(1) == '#';
		}
		for(int j=0;j<2;j++){
		    String str = sc.next();
		    block[i][1][j*2] = str.charAt(0) == '#';
		    block[i][1][1+j*2] = str.charAt(1) == '#';
		}
	    }

	    check(0,H-1,field);

	    System.out.println(max);

	}
    }

    public static void check(int n,int hTop,boolean[][] field){
	if(n>=N){
	    max = Math.max(tmpMax,max);
	    return;
	}

	int oldtmpMax = tmpMax;
	boolean[][] oldField = new boolean[H+7][4];
	for(int i=0;i<H+7;i++){
		for(int j=0;j<4;j++){
			oldField[i][j] = field[i][j];
		}
	}
	boolean[][] blo = new boolean[2][4];
	for(int i=0;i<2;i++){
		for(int j=0;j<4;j++){
			 blo[i][j] = block[n][i][j];
		}
	}


	int stand = hTop;

	if(!blo[0][0] && !blo[0][1] && !blo[0][2] && !blo[0][3]){
	    blo[0][0] = blo[1][0];
	    blo[0][1] = blo[1][1];
	    blo[0][2] = blo[1][2];
	    blo[0][3] = blo[1][3];
	    blo[1][0] = false;
	    blo[1][1] = false;
	    blo[1][2] = false;
	    blo[1][3] = false;
	}

	field = fall(stand,field,blo);
	check(n+1,stand,field);

	for(int i=0;i<H+7;i++){
		for(int j=0;j<4;j++){
			field[i][j] = oldField[i][j];
		}
	}
	tmpMax = oldtmpMax;
	stand = hTop;

	boolean flag = false;

	if(!blo[0][0] && !blo[0][1] && !blo[1][0] && !blo[1][1] ||
	   !blo[0][2] && !blo[0][3] && !blo[1][2] && !blo[1][3]){
	    flag = true;
	    for(int i=0;i<4;i++){
		boolean tmp = blo[i/2][2+i%2];
		blo[i/2][2+i%2] = blo[i/2][i%2];
		blo[i/2][i%2] = tmp;
	    }
	    field = fall(stand,field,blo);
	    check(n+1,stand,field);
		for(int i=0;i<H+7;i++){
			for(int j=0;j<4;j++){
				field[i][j] = oldField[i][j];
			}
		}
	    for(int i=0;i<4;i++){
		boolean tmp = blo[i/2][2+i%2];
		blo[i/2][2+i%2] = blo[i/2][i%2];
		blo[i/2][i%2] = tmp;
	    }
	    tmpMax = oldtmpMax;
	    stand = hTop;
	}

	if(!blo[0][0] && !blo[0][2] && !blo[1][0] && !blo[1][2] ||
	   !blo[0][1] && !blo[0][3] && !blo[1][1] && !blo[1][3]){
	    for(int i=0;i<4;i++){
		boolean tmp = blo[i/2][(i*2)%4];
		blo[i/2][(i*2)%4] = blo[i/2][1+(i*2)%4];
		blo[i/2][1+(i*2)%4] = tmp;
	    }
	    field = fall(stand,field,blo);
	    check(n+1,stand,field);
		for(int i=0;i<H+7;i++){
			for(int j=0;j<4;j++){
				field[i][j] = oldField[i][j];
			}
		}
	    tmpMax = oldtmpMax;
	    stand = hTop;
	    if(flag){
		for(int i=0;i<4;i++){
		    boolean tmp = blo[i/2][2+i%2];
		    blo[i/2][2+i%2] = blo[i/2][i%2];
		    blo[i/2][i%2] = tmp;
		}
		field = fall(stand,field,blo);
		check(n+1,stand,field);
		for(int i=0;i<H+7;i++){
			for(int j=0;j<4;j++){
				field[i][j] = oldField[i][j];
			}
		}
		tmpMax = oldtmpMax;
		stand = hTop;
	    }
	}
    }

    public static boolean[][] fall(int stand,boolean[][] field,boolean[][] block){
	int oldstand = stand;/*
	for(int i=0;i<H+7;i++){
	    System.out.println(i);
	    System.out.println(":" + field[i][0] + " " + field[i][1]);
	    System.out.println(":" + field[i][2] + " " + field[i][3]);
	    }*/

	stand = H+5;

	while(true){
	    if((field[stand][0] && block[0][0]) ||
	       (field[stand][1] && block[0][1]) ||
	       (field[stand][2] && block[0][2]) ||
	       (field[stand][3] && block[0][3]) ||
	       (field[stand+1][0] && block[1][0]) ||
	       (field[stand+1][1] && block[1][1]) ||
	       (field[stand+1][2] && block[1][2]) ||
	       (field[stand+1][3] && block[1][3])){
		stand++;
		break;
	    }
	    else{
		if(stand == 0){
		    break;
		}
		stand--;
	    }
	}
	int tmp = 0;
	int tmp2 = 0;

	if((field[stand][0] ^ block[0][0]) &&
	   (field[stand][1] ^ block[0][1]) &&
	   (field[stand][2] ^ block[0][2]) &&
	   (field[stand][3] ^ block[0][3])){
		field = removeLine(field,stand);
	    tmp++;
	    field = slideField(stand,field);
	}
	else{
		field = addLine(field,block[0],stand);
	}

	if((field[stand+1-tmp][0] ^ block[1][0]) &&
	   (field[stand+1-tmp][1] ^ block[1][1]) &&
	   (field[stand+1-tmp][2] ^ block[1][2]) &&
	   (field[stand+1-tmp][3] ^ block[1][3])){
		field = removeLine(field,stand+1-tmp);
	    field = slideField(stand+1-tmp,field);
	    tmp2++;
	}
	else{
		field = addLine(field,block[1],stand+1-tmp);
	}

	tmpMax += tmp + tmp2;
	return field;
    }


    public static boolean[][] removeLine(boolean[][] field,int stand){
    	field[stand][0] = false;
    	field[stand][1] = false;
    	field[stand][2] = false;
    	field[stand][3] = false;
    	return field;
    }

    public static boolean[][] addLine(boolean[][] field,boolean[] block,int h){
    	field[h][0] = (field[h][0]) ? field[h][0] : block[0];
    	field[h][1] = (field[h][1]) ? field[h][1] : block[1];
    	field[h][2] = (field[h][2]) ? field[h][2] : block[2];
    	field[h][3] = (field[h][3]) ? field[h][3] : block[3];
    	return field;
    }

    public static boolean[][] slideField(int stand,boolean[][] field){
	while(true){
	    if(!field[stand+1][0] && !field[stand+1][1] &&
	       !field[stand+1][2] && !field[stand+1][3]){
		    field[stand][0] = field[stand+1][0];
		    field[stand][1] = field[stand+1][1];
		    field[stand][2] = field[stand+1][2];
		    field[stand][3] = field[stand+1][3];

		return field;
	    }
	    field[stand][0] = field[stand+1][0];
	    field[stand][1] = field[stand+1][1];
	    field[stand][2] = field[stand+1][2];
	    field[stand][3] = field[stand+1][3];
	    stand++;
	}

    }
}