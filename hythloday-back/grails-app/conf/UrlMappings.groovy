class UrlMappings {

	static mappings = {
        name activity: "/activity" { controller = "activity"; action = [ POST: "publish", GET: "list" ] }

	}
}
