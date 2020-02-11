package com.example.demo.dto;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Table(name="board")
@Getter
@Setter
@ToString
@Entity
public class BoardEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long board_no;
	
	@Column
	String board_nm;
	
	@Column
	String board_detail;
	
	@Column
	String user_id;
	
	@Column
	LocalDateTime reg_dtime;
	
	public BoardEntity(Long board_no) {
		this.board_no = board_no;
	}
	
	public BoardEntity() {
		// TODO Auto-generated constructor stub
	}

	public Long getBoard_no() {
		return board_no;
	}

	public void setBoard_no(Long board_no) {
		this.board_no = board_no;
	}

	public String getBoard_nm() {
		return board_nm;
	}

	public void setBoard_nm(String board_nm) {
		this.board_nm = board_nm;
	}

	public String getBoard_detail() {
		return board_detail;
	}

	public void setBoard_detail(String board_detail) {
		this.board_detail = board_detail;
	}

	public String getUse_id() {
		return user_id;
	}

	public void setUse_id(String user_id) {
		this.user_id = user_id;
	}

	public LocalDateTime getReg_dtime() {
		return reg_dtime;
	}

	public void LocalDateTime(LocalDateTime reg_dtime) {
		this.reg_dtime = reg_dtime;
	}
	
	public BoardEntity(Long board_no,String board_nm, String board_detail,String user_id) {
		this.board_no = board_no;
		this.board_nm = board_nm;
		this.board_detail = board_detail;
		this.user_id = user_id;
		this.reg_dtime = reg_dtime.now();
	}
	
	
}
