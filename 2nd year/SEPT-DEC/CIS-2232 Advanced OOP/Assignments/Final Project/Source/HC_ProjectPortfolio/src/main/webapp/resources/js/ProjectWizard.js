/*
 
 ========= CIS 2232 Advanced Object Oriented Programming PWC ==========
  ____            _           _     ____            _    __       _ _       
 |  _ \ _ __ ___ (_) ___  ___| |_  |  _ \ ___  _ __| |_ / _| ___ | (_) ___  
 | |_) | '__/ _ \| |/ _ \/ __| __| | |_) / _ \| '__| __| |_ / _ \| | |/ _ \ 
 |  __/| | | (_) | |  __/ (__| |_  |  __/ (_) | |  | |_|  _| (_) | | | (_) |
 |_|   |_|  \___// |\___|\___|\__| |_|   \___/|_|   \__|_|  \___/|_|_|\___/ 
                |__/                                                         
 
 Project Members: Christopher Sigouin & Matthew Hutchinson
 
 Date: 12-Dec-2015
 Purpose: Final Project
 
 */

$(document).ready(function() {
    
    
    
    // Expand and collapse all accordion boxes
    // REF: http://www.bootply.com/peFUdnwOpZ
    $('.closeall').click(function(){
        $('.accordion-body.in')
          .collapse('hide');
        });
    $('.openall').click(function(){
        $('.accordion-body:not(".in")')
          .collapse('show');
        });
        
        
        
    // Used for 'Milestones' and 'Hyperlinks' to add further boxes
    // REF: http://www.sanwebe.com/2013/03/addremove-input-fields-dynamically-with-jquery
    var max_fields      = 10; //maximum input boxes allowed
    var wrapper_milestones         = $(".input_fields_wrap_milestones"); //Fields wrapper
    var wrapper_hyperlinks         = $(".input_fields_wrap_hyperlinks"); //Fields wrapper
    var add_button_milestones      = $(".add_field_milestones"); //Add button ID
    var add_button_hyperlinks      = $(".add_field_hyperlinks"); //Add button ID
    var inputName       = ""; // Input name based on button click
    
    var x = 1; //initlal text box count
    $(add_button_milestones).click(function(e){ //on add input button click
        e.preventDefault();
        if(x < max_fields){ //max input box allowed
            inputName = "milestones";
            x++; //text box increment
            
        $(wrapper_milestones).append('<div>Milestone: <input type="text" name="'+ inputName +'"/><a href="#" class="remove_field">Remove</a><br/>' +
                                     'Start Date:<input type="date" name="startDate" id="startDate" />End Date:<input type="date" name="endDate" id="endDate" /></div>'); //add input box
        }
    });
    
    $(add_button_hyperlinks).click(function(e){ //on add input button click
        e.preventDefault();
        if(x < max_fields){ //max input box allowed
            x++; //text box increment
            inputName = "hyperlinks";
            $(wrapper_hyperlinks).append('<div>Hyperlink: <input type="text" name="'+ inputName +'"/><a href="#" class="remove_field">Remove</a><br/>' +
                                         'Description: <br/><textarea class="description" name="description" id="hyperlinks"></textarea></div><br/>'); //add input box
        }
    });
    
    $(wrapper_milestones).on("click",".remove_field", function(e){ //user click on remove text
        e.preventDefault(); $(this).parent('div').remove(); x--;
    });
    
    $(wrapper_hyperlinks).on("click",".remove_field", function(e){ //user click on remove text
        e.preventDefault(); $(this).parent('div').remove(); x--;
    });

    
});





