**Todo**
    
    - Relative URL, #, Blanks - Exception handling
    - URLValidator
    - Unit test
    - Regex
    - Unique URLS_HASHSET
    - Threading
    
    
    
###Architecture Design showing Traversal Depth = 2
######HTMLPage1 = Level 0  -  JSOUP traverses _HTMLPage1_
######Link1/Link2/Link3 = Level 1  -  JSOUP traverses _Link1/Link2/Link3_
>HTMLPage1
* Link1-------------------Link1.1
        -------------------Link1.2
        -------------------Link1.3
 * Link2-------------------Link1.1
        -------------------Link2.2
        -------------------Link2.3
        -------------------Link2.4
        -------------------Link2.5
 * Link3-------------------Link3.1
        -------------------Link3.2
        -------------------Link3.3
        -------------------Link3.4 


   
_https://stackoverflow.com/questions/2600653/adjusting-eclipse-console-size_