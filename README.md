<h3>Marooned</h3>

<p>Marooned is a command line program that emulates an interactive programming language. The user may enter commands in either Morse Code or NATO Phonetic Alphabet, and may switch between the two modes if desired.  The user may also modify the keys used as the "dot" and the "dash" characters from their default values of <code>-</code> and <code>=</code>, respectively, to any other two characters at any time. </p>

<p>[ main ]<br />
Marooned.java</p>

<p>[ Help Manual ]<br />
In Morse Code mode, the Help Manual may be accessed by using <code>---===---</code>; in NATO Phonetic Alphabet mode, the Help Manual may be accessed by using <code>MAYDAY</code>.  The full Help Manual for each mode is displayed below.</p>

<i>Morse Code mode</i>

COMMAND | DESCRIPTION | EXAMPLE USAGE | EXAMPLE OUTPUT 
-----------------------|-----------------------|-----------------------|-----------------------
|``=``                      |decision helper        |``= pants nopants``        |``100%, nopants``          |
|``--=``                    |round up or down       |``--= 2.5 up``             |``3``                      |
|``-==``                    |# common letters       |``-== hello``              |``3 letters in common``    |
|``=-==``                   |square root            |``=-== 4``                 |``sqrt(4) = 2``            |
|``---===---``              |display manual         |``---===---``              |(n/a)                  |
|``===---=--=-``            |change mode            |``===---=--=- -m npa``     |(n/a)                  |
|``===--==``                |quit program           |(n/a)                  |(n/a)                  |


<i>NATO Phonetic Alphabet mode</i>

COMMAND                |DESCRIPTION            |EXAMPLE USAGE          |EXAMPLE OUTPUT         |
-----------------------|-----------------------|-----------------------|-----------------------
|``ALPHA``                  |add                    |``ALPHA 3 12``             |``3 + 12 = 15``            |
|``BRAVO``                  |category item          |``BRAVO weather``          |``Tornado``                |
|``CHARLIE``                |companion              |``CHARLIE Howdy Chaz!``    |``Get it together.``       |
|``DELTA``                  |subtract               |``DELTA 10 4``             |``10 - 4 = 6``             |
|``MAYDAY``                 |display manual         |``MAYDAY``                 |(n/a)                  |
|``OVER``                   |change mode            |``OVER -m mc l o``         |(n/a)                  |
|``OUT``                    |quit program           |``OUT``                    |(n/a)                  |
