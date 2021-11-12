package com.example

/**
 *
 * @author ksipe
 */

import com.acme.account.AccountDao
// Used as an older example but requires new annotations
//import javax.annotation.Resource
import spock.lang.Specification

// Spring imports omitted for brevity

//@ContextConfiguration(locations = "appcontext.xml")
class SpringExampleSpec extends Specification {

//    @Resource
    AccountDao email

//  @Autowired
//  ApplicationContext context

    /**
     * leaving out spring references so this project doesn't require a GB of download for this simple example
     * requires:
     *
     * spring-beans
     * spring-test
     * spock-spring
     *
     */
}
