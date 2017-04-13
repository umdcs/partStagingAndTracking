# United Piping Node Server 

Note: This is currently running on a local machine, not akka or ukko (Will put on akka or ukko next time we meet... Probably tomorrow if all goes well)

/addJob, /updateJob, and /importantInfo are now working

Also began trying to format the Manager Dashboard, now everything is alphebatized and I don't know why, but it certainly shouldn't be.

No work has been done on trying to get information back from the server yet, but I found a nice website that gave me an idea as to how we could do it.. 


//This is what I found, I think number 2 will be our best option
Gson gson = new Gson();

// 1. JSON to Java object, read it from a file.
Staff staff = gson.fromJson(new FileReader("D:\\file.json"), Staff.class);

// 2. JSON to Java object, read it from a Json String.
String jsonInString = "{'name' : 'mkyong'}";
Staff staff = gson.fromJson(jsonInString, Staff.class);

// JSON to JsonElement, convert to String later.
JsonElement json = gson.fromJson(new FileReader("D:\\file.json"), JsonElement.class);
String result = gson.toJson(json);

