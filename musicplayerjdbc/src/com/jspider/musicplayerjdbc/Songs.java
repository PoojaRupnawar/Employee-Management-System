package com.jspider.musicplayerjdbc;

public class Songs 
{
	private int id;
	private String songName;
	private String singerName;
	private String movieName;
	private double songDuration;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	public String getSingerName() {
		return singerName;
	}

	public void setSingerName(String singerName) {
		this.singerName = singerName;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public double getSongDuration() {
		return songDuration;
	}

	public void setSongDuration(double songDuration) {
		this.songDuration = songDuration;
	}

	@Override
	public String toString() {
		return "Songs [id=" + id + ", songName=" + songName + ", singerName=" + singerName + ", movieName=" + movieName
				+ ", songDuration=" + songDuration + "]";
	}
	
	
}

	

		

	
