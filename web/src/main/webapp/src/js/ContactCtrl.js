angular.module("website.controllers")
    .controller('contactCtrl', function($scope, $rootScope, $route, $routeParams, $location, $http) {

        $scope.handleFormSubmit =  function() {  // handles form submit withtout any jquery
            var data = getFormData();         // get the values submitted in the form
            var hasErrors = false;
            clearErrors();

            if(!validName(data.name)) {   // if email is not valid show error
                document.getElementById('name-invalid').style.display = 'block';
                hasErrors = true;
            }

            if(!validEmail(data.email)) {   // if email is not valid show error
                document.getElementById('email-invalid').style.display = 'block';
                hasErrors = true;
            }

            if(!validPhoneNumber(data.number)) {   // if email is not valid show error
               document.getElementById('number-invalid').style.display = 'block';
               hasErrors = true;
            }

            if(!validMessage(data.message)) {   // if email is not valid show error
                document.getElementById('message-invalid').style.display = 'block';
                hasErrors = true;
            }

            if (hasErrors === true) {
                return false;
            }

            var url = "https://script.google.com/macros/s/AKfycbzH73KDClQ9-vrzhUZiVuANnZQmlh6Ardhqw808iMJZumVSV_g/exec";
            var xhr = new XMLHttpRequest();
            xhr.open('POST', url);
            // xhr.withCredentials = true;
            xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
            xhr.onreadystatechange = function() {
                console.log( xhr.status, xhr.statusText )
                console.log(xhr.responseText);
                document.getElementById('gform').style.display = 'none'; // hide form
                document.getElementById('thankyou_message').style.display = 'block';
                return;
            };
            // url encode form data for sending as post data
            var encoded = Object.keys(data).map(function(k) {
                return encodeURIComponent(k) + '=' + encodeURIComponent(data[k])
            }).join('&')
            xhr.send(encoded);

        }

        function clearErrors(){
            document.getElementById('name-invalid').style.display = 'none';
            document.getElementById('email-invalid').style.display = 'none';
            document.getElementById('number-invalid').style.display = 'none';
            document.getElementById('message-invalid').style.display = 'none';
        }

        function validEmail(email) { // see:
            var re = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
            return re.test(email);
        }

        function validMessage(msg) {
            var re = /^\S+/;
            return re.test(msg);
        }

        function validPhoneNumber(number) {
            var re = /^[0-9]{8,12}$/;
            return re.test(number);
        }

        function validName(name) {
            var re = /^\S+/;
            return re.test(name);
        }

        // get all data in form and return object
        function getFormData() {
            var elements = document.getElementById("gform").elements; // all form elements
            var fields = Object.keys(elements).map(function(k) {
            if(elements[k].name !== undefined) {
              return elements[k].name;
            // special case for Edge's html collection
            }else if(elements[k].length > 0){
              return elements[k].item(0).name;
            }
            }).filter(function(item, pos, self) {
            return self.indexOf(item) == pos && item;
            });
            var data = {};
            fields.forEach(function(k){
            data[k] = elements[k].value;
            var str = ""; // declare empty string outside of loop to allow
                          // it to be appended to for each item in the loop
            if(elements[k].type === "checkbox"){ // special case for Edge's html collection
              str = str + elements[k].checked + ", "; // take the string and append
                                                      // the current checked value to
                                                      // the end of it, along with
                                                      // a comma and a space
              data[k] = str.slice(0, -2); // remove the last comma and space
                                          // from the  string to make the output
                                          // prettier in the spreadsheet
            }else if(elements[k].length){
              for(var i = 0; i < elements[k].length; i++){
                if(elements[k].item(i).checked){
                  str = str + elements[k].item(i).value + ", "; // same as above
                  data[k] = str.slice(0, -2);
                }
              }
            }
            });
            console.log(data);
            return data;
        }

    }
)