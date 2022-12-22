package ez.web.day05;

public class MyScore {
	private int kor;
	private int eng;
	private int mat;
	
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMat() {
		return mat;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
	
	public int getTotal() {
		return kor+eng+mat;
	}
	
	@Override
	public String toString() {
		return "MyScore [kor=" + kor + ", eng=" + eng + ", mat=" + mat + "]";
	}
	
	
}
