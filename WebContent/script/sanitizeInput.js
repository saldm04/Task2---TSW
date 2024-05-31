document.addEventListener("DOMContentLoaded", function() {
    document.getElementById("myform").addEventListener("submit", function(event) {
        let inputs = document.querySelectorAll("input[type='text']");
        inputs.forEach(input => {
            input.value = input.value.replace(/[<>]/g, "");
        });
    });
});
