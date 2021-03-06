package user.note.usernotewithcloudoauth2.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="user")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="userid")
	private Long userId;
	
	@Column(name="email")
	@NotBlank
	@Email
	private String email;
	
	@Column(name="password")
	@NotBlank
	@Min(8)
	private String password;
	
	@Column(name="createtime")
	private Date createTime;
	
	@Column(name="lastupdatetime")
	private Date lastUpdateTime;
	
	@OneToMany(targetEntity=Note.class,mappedBy="user",fetch=FetchType.EAGER,cascade=CascadeType.ALL,orphanRemoval=true)
	@JsonIgnoreProperties("user")
	private List<Note> noteList = new ArrayList<Note>();

	public User() {
		//default constructor
	}
	public User(Long userId, @NotBlank @Email String email, @NotBlank @Min(8) String password, Date createTime,
			Date lastUpdateTime, List<Note> noteList) {
		this.userId = userId;
		this.email = email;
		this.password = password;
		this.createTime = createTime;
		this.lastUpdateTime = lastUpdateTime;
		this.noteList = noteList;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public List<Note> getNoteList() {
		return noteList;
	}

	public void setNoteList(List<Note> noteList) {
		this.noteList = noteList;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", email=" + email + ", password=" + password + ", createTime=" + createTime
				+ ", lastUpdateTime=" + lastUpdateTime + ", noteList=" + noteList + "]";
	}	
}
