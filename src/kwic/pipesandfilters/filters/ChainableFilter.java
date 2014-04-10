/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kwic.pipesandfilters.filters;

import kwic.pipesandfilters.pipes.FilterChain;

/**
 *
 * @author Petr Kalivoda
 */
public interface ChainableFilter {
    public void setChain(FilterChain fc);
}
