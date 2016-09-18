package models;

import java.time.LocalTime;
import java.util.UUID;
import javax.persistence.*;

import org.hibernate.annotations.Type;




@Entity
@Table
public class ScheduledItem {
	@Id
	@Type(type="uuid-char")
	private UUID id;
	//this is in order to enable manually ordering this entity in a list
	private int sequenceId;
	

	private LocalTime startingHour;
	private LocalTime endingHour;
	private String title;
	
	public ScheduledItem(){
		this.setId(UUID.randomUUID());
	}
	
	public ScheduledItem(UUID uuid, int sequenceId, String title, LocalTime startinghour, LocalTime endingHour){
		this.setId(uuid);
		this.setSequenceId(sequenceId);
		this.setTitle(title);
		this.setStartingHour(startinghour);
		this.setEndingHour(endingHour);
	}
	
	public ScheduledItem(UUID uuid, int sequenceId, String title, int startinghour, int startingMinute, int endingHour, int endingMinute){
		
		this(uuid, sequenceId, title, LocalTime.of(startinghour, startingMinute), LocalTime.of(endingHour, endingMinute));
		
	}
	
	
	
	
	
	public LocalTime getStartingHour() {
		return startingHour;
	}
	public void setStartingHour(LocalTime startingHour) {
		this.startingHour = startingHour;
	}
	public LocalTime getEndingHour() {
		return endingHour;
	}
	public void setEndingHour(LocalTime endingHour) {
		this.endingHour = endingHour;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public UUID getId() {
		return id;
	}
	
	public void setId(UUID uuid){
		this.id = uuid;
	}
	
	public int getSequenceId() {
		return sequenceId;
	}

	public void setSequenceId(int sequenceId) {
		this.sequenceId = sequenceId;
	}
	
	
	

}
