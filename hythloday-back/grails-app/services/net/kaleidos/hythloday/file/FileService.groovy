package net.kaleidos.hythloday.file

class FileService {
    def grailsApplication
    
    public create(InputStream inputStream, String path, String name) {
        if (inputStream == null) {
            log.error 'Error create - param inputStream is null'
            return false
        }

        if (!name || name.trim() == "") {
            log.error "Error create - param name is null or empty. name = '$name'"
            return false
        }

        if (!path || path.trim() == "") {
            log.warn "Param path is null or empty. path = '$path'"
        }

        String localFileBasePath = grailsApplication.config.local_file_base_path
        
        def file
        def dir = "$localFileBasePath/$path"
        def url = "$dir/${name}"

        try {
            try {
                file = new File(url) << inputStream
            } catch (java.io.FileNotFoundException e) {
                log.debug "creating dir: $dir"
                new File(dir).mkdirs()
                file = new File(url) << inputStream
            }
        } catch (java.io.FileNotFoundException e) {
            log.error e.message
            log.error e.cause
            log.error "Error creating 'path/name': '$path/$name'"

            return false
        }

        return true
    }

    public boolean delete(String path, String name) {
        def url = "$path/$name"

        String localFileBasePath = grailsApplication.config.local_file_base_path

        try {
            return new File("${localFileBasePath}/${url}").delete()
        } catch (java.io.FileNotFoundException e) {
            log.error "Error deleting 'path/name': '$path/$name'"
            return false
        }

        return true
    }
    
    public File get(String path, String name) {
        String localFileBasePath = grailsApplication.config.local_file_base_path

        def file = new File("$localFileBasePath/$path/${name}")

        if (!file.exists()) {
            log.error "Error file not exists 'path/name': '$path/$name'"
            return null
        }

        return file
    }

    protected String getBaseUrl() {
        return grailsApplication.config.grails.serverURL
    }

    public String getUrl(String path, String name) {
        def baseUrl = this.getBaseUrl()

        def result = baseUrl
        if (path != null && path.trim() != "") {
            result += "/${path}"
        }

        result += "/${name}"

        //Fix double slash
        result = result.replace("//", "/")
        result = result.replace("http:/", "http://")
        result = result.replace("https:/", "https://")
        
        return result
    }
}