package kr.mrhi.test0219;

import java.util.Objects;

public class ScoreTable {
	private String s_num ;
	private String s_name ;
	private int s_java ;
	private int s_c ;
	private int s_sql ;
	private int s_total ;
	private double s_avg ;
	private String s_grade ;
	
	ScoreTable(){
		this(null,null,0,0,0,0,0.0,null);
	}
	ScoreTable( String s_num,String s_name,int s_java,int s_c,int s_sql,int s_total,double s_avg,String s_grade){
		this.s_num = s_num ;
		this.s_name = s_name ;
		this.s_java = s_java ;
		this.s_c = s_c ;
		this.s_sql = s_sql;
		this.s_total = s_total;
		this.s_avg = s_avg;
		this.s_grade = s_grade;
	}
	//----------------------------------
	@Override
	public int hashCode() {
		return Objects.hash(s_num);
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof ScoreTable) {
			ScoreTable st = (ScoreTable)obj;
			if(st.s_num.equals(this.s_num)) {
				return true;
			}
		}
		return false;
	}
	@Override
	public String toString() {
		return s_num + "\t" + s_name + "\t"+ s_java + "\t"+ s_c + "\t"
				+ s_sql + "\t" + s_total + "\t" + s_avg + "\t"+ s_grade ;
	}
	
	//----------------------------------
	public String getS_num() {
		return s_num;
	}
	public void setS_num(String s_num) {
		this.s_num = s_num;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public int getS_java() {
		return s_java;
	}
	public void setS_java(int s_java) {
		this.s_java = s_java;
	}
	public int getS_c() {
		return s_c;
	}
	public void setS_c(int s_c) {
		this.s_c = s_c;
	}
	public int getS_sql() {
		return s_sql;
	}
	public void setS_sql(int s_sql) {
		this.s_sql = s_sql;
	}
	public int getS_total() {
		return s_total;
	}
	public void setS_total(int s_total) {
		this.s_total = s_total;
	}
	public double getS_avg() {
		return s_avg;
	}
	public void setS_avg(double s_avg) {
		this.s_avg = s_avg;
	}
	public String getS_grade() {
		return s_grade;
	}
	public void setS_grade(String s_grade) {
		this.s_grade = s_grade;
	}

}
