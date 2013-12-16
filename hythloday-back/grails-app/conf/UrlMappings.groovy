class UrlMappings {

	static mappings = {
        name createActivity: "/activity" { controller = "activity"; action = [ POST: "publish" ] }
	}
}
