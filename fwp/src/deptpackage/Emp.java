package deptpackage;

public class Emp 
{

int empno;
String name,deptid;
public Emp(int empno, String name, String deptid) {
	super();
	this.empno = empno;
	this.name = name;
	this.deptid = deptid;
}
public int getEmpno() {
	return empno;
}
public void setEmpno(int empno) {
	this.empno = empno;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDeptid() {
	return deptid;
}
public void setDeptid(String deptid) {
	this.deptid = deptid;
}

	@Override
public String toString() {
	return "Emp [empno=" + empno + ", name=" + name + ", deptid=" + deptid + "]";
}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + empno;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Emp)) {
			return false;
		}
		Emp other = (Emp) obj;
		if (empno != other.empno) {
			return false;
		}
		return true;
	}
}
