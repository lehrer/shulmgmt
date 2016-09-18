package controllers;

import java.time.LocalTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import models.ScheduledItem;

@RestController
public class ScheduledItemController {
	
	public ScheduledItemController(){
		//int countOfDeletedItems = DataLinkLayer.clearDatabase();
	}
	
	@RequestMapping(value="/addScheduledItem", method=RequestMethod.POST)
	//public @ResponseBody ScheduledItem getScheduledItem(@RequestParam(value = "title", defaultValue = "geen titel ingevoerd") String title) {
	public @ResponseBody ScheduledItem getScheduledItem(@RequestBody ScheduledItem scheduledItem) {
	DataLinkLayer.makeScheduledItemPersistent(scheduledItem);
		return scheduledItem;
	}
	
	
	@RequestMapping(value="/deleteScheduledItem", method=RequestMethod.POST)
	public @ResponseBody void deleteScheduledItem(@RequestBody(required=true) Object id){
		LinkedHashMap map = (LinkedHashMap)id;
		Map.Entry me = (Map.Entry)map.entrySet().iterator().next();
		UUID tmp =UUID.fromString((String) me.getValue());
		int deletedCount = DataLinkLayer.deleteScheduledItem(tmp);
		
		
	}
	
	
	@RequestMapping(value="/getScheduledItems", method=RequestMethod.GET)
	public List<ScheduledItem> getScheduledItem() {
		List<ScheduledItem> scheduledItems = DataLinkLayer.getAllScheduledItems();
		return scheduledItems;
	}

}
