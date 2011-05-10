var prefix = ['is','create','get','set','validate','insert','remove','do','process','return','run','persist','abstract','does','wait','enable','disable','emergency','first','last','flush','flip','lookup','write','read'];
var mid = ['Object','Processor','Database','Integer','Number','Form','HTML','XML', 'Business','CRM','Customer','User','Permits', 'Logger', 'Element']
var end = ['Tree','Set','Record','Entity','Singleton','Command','Strategy','Parameter','Function','Value','Method','Procedure','Subroutine']

function getOne(x) {
    var n = x.length;
    return x[Math.floor(Math.random() * n)];
}

function generateTerribleName () {
    return getOne(prefix) + getOne(mid) + getOne(end);
}

function generateName(src, maxLength) {
    var methodLen = Math.floor(Math.random() * (maxLength-1)) + 1;

    var choices = [];
    for (var i=0;i<src.length;++i) {
        if (src[i].length == methodLen) {
            choices.push(src[i]);
        }
    }

    if (choices.length == 0) {
        return generateName(src,maxLength);
    }

    var methodName = '';
    for (var i=0;i<methodLen;++i) {
        var word = choices[Math.floor(Math.random() * choices.length)][i];
        if (i != 0) {
            word = word.substring(0,1).toUpperCase() + word.substring(1,word.length);
        } 
        methodName += word;
    }

    return methodName;
}
