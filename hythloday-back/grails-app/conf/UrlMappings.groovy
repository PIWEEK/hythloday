class UrlMappings {

	static mappings = {
        name activities: "/activity" { controller = "activity"; action = [ POST: "publish", GET: "list" ] }
        name activity: "/activity/$activityId" { controller = "activity"; action = "detail" }
        name comment: "/comment/" { controller = "comment"; action = [ POST: "publish" ] }
        name category: "/category/" { controller = "category"; action = [ GET: "list" ] }                
	}
}
