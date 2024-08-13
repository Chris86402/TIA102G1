
        $(document).ready(function () {
        	const csrftoken = getCookie('csrftoken');
        	
            $("#countySelect").change(function () {
            	let selectedCounty = $(this).val();
            	getDist(selectedCounty, csrftoken);
            });
        	
        });
        
        function getCookie(name) {
            let cookieValue = null;
            if (document.cookie && document.cookie !== '') {
                const cookies = document.cookie.split(';');
                for (let i = 0; i < cookies.length; i++) {
                    const cookie = cookies[i].trim();
                    if (cookie.substring(0, name.length + 1) === (name + '=')) {
                        cookieValue = decodeURIComponent(cookie.substring(name.length + 1));
                        break;
                    }
                }
            }
            return cookieValue;
        }
        
        function getDist(selectedCounty, csrftoken){
            $.ajax({
                type: "GET",
                data: { "cntCode": selectedCounty },
                headers: { 'X-CSRFToken': csrftoken },
                url: "../dists/",
                dataType: "json",
                success: function (data) {   
					let pageType = $("#pageType").val();                 
                    let distSelect = $("#distSelect");
                    distSelect.empty();
                    if(pageType == "mainPage"){
                    	distSelect.append(new Option("不限鄉鎮區", ""));
                    }
                    data["dists"].forEach(function (item, i) {
                        distSelect.append(new Option(item["distName"], item["distCode"]));
                    });
                }
            })
        }
