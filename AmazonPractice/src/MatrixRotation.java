
public class MatrixRotation {
	
	public int[][] matrixRot(int a[][]){
		int n=a.length;
		if(n < 1) {
			return a;
		}
		for (int i=0; i< n/2; i++) {
			for (int j=i; j<n-i-1; j++) {
				int m = a[i][j];
				a[i][j] = a[n-j-1][i];
				a[n-j-1][i] = a[n-i-1][n-j-1];
				a[n-i-1][n-j-1] = a[j][n-i-1];
				a[j][n-i-1] = m;
			}
		}
		return a;
	}
	
	public void printMatrix(int a[][]) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				System.out.print(a[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void main(String args[]){
		MatrixRotation mr = new MatrixRotation();
		int a[][] = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
               };
		mr.printMatrix(a);
		System.out.println();
		a = mr.matrixRot(a);
		mr.printMatrix(a);
	}

}
