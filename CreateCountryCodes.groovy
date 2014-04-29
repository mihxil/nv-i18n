import com.neovisionaries.i18n.CountryCode

def slurper = new XmlSlurper()
def html = slurper.parse("http://en.wikipedia.org/wiki/ISO_3166-3")



def table = html.'**'.find{it.name() == 'table'}
table.tr.each {
    if (it.td.size() > 0) {
        def name = it.td[0].a.@title.text()
        if (! name ) name = it.td[0].span.a.@title.text()
        int numb = 0
        it.td[1].tt.each {
            def other = it.text()
            if (other =~ /[0-9]+/) numb = it.text().toInteger()
        }
        def code = it.th[0].tt.text()
        if (CountryCode.getByCode(numb) == null) {
            println  '/**'
            println  " * <a href=\"https://www.iso.org/obp/ui/#iso:code:3166:${code}\">${code}</a>, ${numb}"
            println  ' **/'
            println code + "(\"" + name + "\", \"" + code + "\"," + numb + ", Assignment.FORMALLY_USED),\n\n"
        }
    }

}
